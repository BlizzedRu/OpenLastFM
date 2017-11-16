package ru.blizzed.openlastfm.methods;

/**
 * Bean class for LastFM API response
 *
 * @param <ResultType> type of result model
 * @author BlizzedRu
 * @see ApiRequest#execute()
 * @see ApiRequest#execute(ApiRequest.ApiRequestListener)
 * @see ApiRequest#executeEnqueue(ApiRequest.ApiRequestListener)
 */
public class ApiResponse<ResultType> {

    private ApiRequest request;
    private String originalResponse;
    private ResultType content;

    ApiResponse(ApiRequest request, String response, ResultType content) {
        this.request = request;
        this.originalResponse = response;
        this.content = content;
    }

    /**
     * Returns a parent {@link ApiRequest} gave birth to this request
     *
     * @return initial {@link ApiRequest}
     */
    public ApiRequest getRequest() {
        return request;
    }

    /**
     * Returns a parsed content of LastFM response
     *
     * @return parsed content
     */
    public ResultType getContent() {
        return content;
    }

    /**
     * Returns original response as {@link String}
     *
     * @return original response as {@link String}
     */
    public String getOriginalResponse() {
        return originalResponse;
    }

}
