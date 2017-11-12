package ru.blizzed.openlastfm.methods;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.istack.internal.NotNull;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.blizzed.openlastfm.OpenLastFMContext;
import ru.blizzed.openlastfm.RequestsExecutor;
import ru.blizzed.openlastfm.models.Error;
import ru.blizzed.openlastfm.models.ObjectModelParser;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class ApiRequest<ResultType> {

    public interface ApiRequestListener<ResponseType> {
        default void onComplete(ApiResponse<ResponseType> response) {
        }
        default void onFailure(ApiRequest request, IOException exception) {
        }
        default void onApiError(ApiResponse<Error> error) {
        }
    }

    private static Logger log = LogManager.getLogger(ApiRequest.class);

    private ApiMethod<ResultType> method;
    private ApiParams params;

    public ApiRequest(ApiMethod<ResultType> method, ApiParams params) {
        this.method = method;
        this.params = params;
    }

    public ApiMethod getMethod() {
        return method;
    }

    public ApiParams getParams() {
        return params;
    }

    public void executeEnqueue(@NotNull ApiRequestListener<ResultType> listener) {
        RequestsExecutor.getInstance().executeEnqueue(this, getDefaultCallBack(listener));
    }

    public void execute(@NotNull ApiRequestListener<ResultType> listener) {
        RequestsExecutor.getInstance().execute(this, getDefaultCallBack(listener));
    }

    public void cancel() {
        RequestsExecutor.getInstance().cancel(this);
    }

    private void handleResponse(ApiRequestListener<ResultType> listener, Response response) throws IOException {
        if (response.isSuccessful()) parseAndNotify(response.body().string(), listener);
        else notifyError(listener, buildErrorResponse(response));
        response.close();
    }

    private void parseAndNotify(String originalResponse, ApiRequestListener<ResultType> listener) {
        JsonParser parser = new JsonParser();
        JsonObject root = parser.parse(originalResponse).getAsJsonObject();

        if (isApiError(root)) notifyError(listener, buildErrorResponse(originalResponse, root));
        else notifyComplete(listener, buildResultResponse(originalResponse, root));
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
        if (listener != null) listener.onFailure(this, e);
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
