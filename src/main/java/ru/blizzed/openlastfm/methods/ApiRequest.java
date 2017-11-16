package ru.blizzed.openlastfm.methods;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.istack.internal.NotNull;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import ru.blizzed.openlastfm.ApiRequestException;
import ru.blizzed.openlastfm.ApiResponseException;
import ru.blizzed.openlastfm.OpenLastFMContext;
import ru.blizzed.openlastfm.RequestsExecutor;
import ru.blizzed.openlastfm.models.ObjectModelParser;
import ru.blizzed.openlastfm.models.commons.Error;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * This class represents a request to LastFm API
 * <p>Can be executed to call the API
 *
 * @param <ResultType> expected response model type
 * @author BlizzedRu
 */
public final class ApiRequest<ResultType> {

    /**
     * A common callback for request executing
     * <p>You must not override all methods, you can choose such as you want
     *
     * @param <ResponseType> expected response model type
     */
    public interface ApiRequestListener<ResponseType> {
        /**
         * This method triggers you when call to API has been completed successfully
         *
         * @param response parsed {@link ApiResponse}
         */
        default void onComplete(ApiResponse<ResponseType> response) {
        }

        /**
         * This method triggers you when API has been called but response contains an error
         *
         * @param error parsed {@link ApiResponse} with {@link Error}
         */
        default void onApiError(ApiResponse<Error> error) {
        }

        /**
         * This method triggers you when call to API cannot be established
         * <p>E.g. no internet connection
         *
         * @param exception an exception that contains initial message and {@link ApiRequest}
         */
        default void onFailure(ApiRequestException exception) {
        }
    }

    private ApiMethod<ResultType> method;
    private ApiParams params;

    /**
     * @param method a {@link ApiMethod} that you want to call
     * @param params a {@link ApiParams} of method that you want to call with
     */
    public ApiRequest(ApiMethod<ResultType> method, ApiParams params) {
        this.method = method;
        this.params = params;
    }

    /**
     * Returns initial {@link ApiMethod} of this request
     *
     * @return initial method
     */
    public ApiMethod getMethod() {
        return method;
    }

    /**
     * Returns initial {@link ApiParams} of this request
     *
     * @return initial params
     */
    public ApiParams getParams() {
        return params;
    }

    /**
     * Makes an enqueue call to the LastFM API
     *
     * @param listener {@link ApiRequestListener} to get callbacks
     * @see #execute(ApiRequestListener)
     */
    public void executeEnqueue(@NotNull ApiRequestListener<ResultType> listener) {
        RequestsExecutor.getInstance().executeEnqueue(this, getDefaultCallBack(listener));
    }

    /**
     * Makes a call to the LastFM API
     * <p>
     * <p>That's the main variant to call the LastFM API
     * <p>If you don't want or can't deal with {@link ApiRequestListener} you can use {@link #execute()} method
     * <p>You can get callbacks using {@link ApiRequestListener} as a param
     *
     * @see ApiRequestListener
     * @see #execute()
     *
     * @param listener {@link ApiRequestListener} to get callbacks
     */
    public void execute(@NotNull ApiRequestListener<ResultType> listener) {
        RequestsExecutor.getInstance().execute(this, getDefaultCallBack(listener));
    }

    /**
     * Makes a call to the LastFM API
     * <p>
     * This variant of <tt>execute method</tt> can be used if you don't want or can't deal with {@link ApiRequestListener}
     * <p>That's good for building coherent requests logic
     * <p>You can get errors by catching exceptions – {@link ApiResponseException} and {@link ApiRequestException}
     *
     * @see ApiResponseException
     * @see ApiRequestException
     *
     * @return parsed {@link ApiResponse} with expected result model type
     * @throws ApiResponseException when API has been called but response contains an error
     * @throws ApiRequestException when call to API cannot be established
     */
    public ApiResponse<ResultType> execute() throws ApiResponseException, ApiRequestException {
        try (Response response = RequestsExecutor.getInstance().execute(this)) {
            return handleResponse(response);
        } catch (IOException e) {
            throw new ApiRequestException(e, this);
        }
    }

    /**
     * Cancels current request if it's executing or staying in queue
     */
    public void cancel() {
        RequestsExecutor.getInstance().cancel(this);
    }

    private ApiResponse<ResultType> handleResponse(Response response) throws ApiResponseException, IOException {
        String body = response.body().string();
        JsonObject root = getAsJson(body);
        if (!response.isSuccessful())
            throw new ApiResponseException(buildErrorResponse(response));
        if (isApiError(root))
            throw new ApiResponseException(buildErrorResponse(body, root));
        else return buildResultResponse(body, root);
    }

    private void handleResponse(ApiRequestListener<ResultType> listener, Response response) throws IOException {
        if (response.isSuccessful()) parseAndNotify(response.body().string(), listener);
        else notifyError(listener, buildErrorResponse(response));
    }

    private void parseAndNotify(String originalResponse, ApiRequestListener<ResultType> listener) {
        JsonObject root = getAsJson(originalResponse);
        if (isApiError(root)) notifyError(listener, buildErrorResponse(originalResponse, root));
        else notifyComplete(listener, buildResultResponse(originalResponse, root));
    }

    private JsonObject getAsJson(String body) {
        JsonParser parser = new JsonParser();
        return parser.parse(body).getAsJsonObject();
    }

    @SuppressWarnings("unchecked")
    private ApiResponse<ResultType> buildResultResponse(String originalResponse, JsonObject root) {
        return new ApiResponse<>(this, originalResponse, (ResultType) getMethod().getModelParser().parse(root));
    }

    private ApiResponse<Error> buildErrorResponse(String originalResponse, JsonObject root) {
        return new ApiResponse<>(this, originalResponse, new ObjectModelParser<>("error", Error.class).parse(root));
    }

    private ApiResponse<Error> buildErrorResponse(Response response) {
        return new ApiResponse<>(this, "", new Error(response.code(), response.message()));
    }

    private boolean isApiError(JsonObject root) {
        return root.keySet().iterator().next().equals(Error.JSON_KEY);
    }

    private void notifyComplete(ApiRequestListener<ResultType> listener, ApiResponse<ResultType> response) {
        if (listener != null) listener.onComplete(response);
    }

    private void notifyError(ApiRequestListener<ResultType> listener, ApiResponse<Error> response) {
        if (listener != null) listener.onApiError(response);
    }

    private void notifyFailure(ApiRequestListener<ResultType> listener, IOException e) {
        if (listener != null) listener.onFailure(new ApiRequestException(e, this));
    }

    private Callback getDefaultCallBack(ApiRequestListener<ResultType> listener) {
        return new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                notifyFailure(listener, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handleResponse(listener, response);
                response.close();
            }
        };
    }

    /**
     * Returns this request as {@link String}
     * <p>It is full build request in URL format
     * @return built request in URL format
     */
    public String asString() {
        StringBuilder request = new StringBuilder(OpenLastFMContext.getRootUrl());
        request.append("&method=")
                .append(method.getFullAlias())
                .append("&api_key=")
                .append(OpenLastFMContext.getApiKey());

        params.asList()
                .forEach(param -> request
                        .append("&")
                        .append(param.name())
                        .append("=")
                        .append(encode(param.getData().toString()))
                );

        if (!params.asList().contains(LastFMParams.LANG))
            request.append("&lang=").append(OpenLastFMContext.getLang());

        return request.toString();
    }

    /**
     * URL Encodes the given String <code>str</code> using the UTF-8 character encoding.
     *
     * @param str a String
     * @return url encoded string
     */
    private static String encode(String str) {
        if(str == null) return null;
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // UTF-8 is always available
        }
        return null;
    }

}
