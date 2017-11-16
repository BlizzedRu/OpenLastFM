package ru.blizzed.openlastfm;

import ru.blizzed.openlastfm.methods.ApiResponse;
import ru.blizzed.openlastfm.models.commons.Error;

public class ApiResponseException extends Exception {

    private ApiResponse<Error> errorResponse;

    public ApiResponseException(ApiResponse<Error> errorResponse) {
        this.errorResponse = errorResponse;
    }

    public ApiResponse<Error> getErrorResponse() {
        return errorResponse;
    }

}
