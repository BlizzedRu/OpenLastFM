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

package ru.blizzed.openlastfm.methods;

/**
 * Bean class for LastFM API response
 *
 * @param <ResultType> type of result model
 * @see ApiRequest#execute()
 * @see ApiRequest#execute(ApiRequest.ApiRequestListener)
 * @see ApiRequest#executeEnqueue(ApiRequest.ApiRequestListener)
 *
 * @author BlizzedRu
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
