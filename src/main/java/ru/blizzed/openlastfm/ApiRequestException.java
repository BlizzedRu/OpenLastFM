package ru.blizzed.openlastfm;

import ru.blizzed.openlastfm.methods.ApiRequest;

import java.io.IOException;

public class ApiRequestException extends IOException {

    private ApiRequest apiRequest;

    public ApiRequestException(IOException e, ApiRequest apiRequest) {
        super(e);
        this.apiRequest = apiRequest;
    }

    public ApiRequest getApiRequest() {
        return apiRequest;
    }

}
