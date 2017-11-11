package ru.blizzed.openlastfm.methods;

public class ApiResponse<ResultType> {

    private ApiRequest request;
    private String originalResponse;
    private ResultType data;

    ApiResponse(ApiRequest request, String response, ResultType data) {
        this.request = request;
        this.originalResponse = response;
        this.data = data;
    }

    public ApiRequest getRequest() {
        return request;
    }

    public ResultType getContent() {
        return data;
    }

    public String getOriginalResponse() {
        return originalResponse;
    }

}
