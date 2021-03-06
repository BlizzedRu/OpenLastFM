/*
 * Copyright (c) 2017 BlizzedRu (Ivan Vlasov)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.blizzed.openlastfm;

import ru.blizzed.openlastfm.methods.ApiResponse;
import ru.blizzed.openlastfm.models.commons.Error;

/**
 * This exception can be thrown when API has been called but response contains an error
 *
 * @author BlizzedRu
 */
public class ApiResponseException extends Exception {

    private ApiResponse<Error> errorResponse;

    public ApiResponseException(ApiResponse<Error> errorResponse) {
        super(errorResponse.getContent().getMessage());
        this.errorResponse = errorResponse;
    }

    /**
     * Returns {@link ApiResponse} that contains an {@link Error}
     *
     * @return response with error
     */
    public ApiResponse<Error> getErrorResponse() {
        return errorResponse;
    }

}
