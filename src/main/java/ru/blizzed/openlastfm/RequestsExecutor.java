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

import okhttp3.*;
import ru.blizzed.openlastfm.methods.ApiRequest;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class executes all {@link ApiRequest} using {@link OkHttpClient}
 *
 * @author BlizzedRu
 * @see ApiRequest#execute()
 * @see ApiRequest#execute(ApiRequest.ApiRequestListener)
 * @see ApiRequest#executeEnqueue(ApiRequest.ApiRequestListener)
 */
public class RequestsExecutor {

    private static RequestsExecutor instance;

    private OkHttpClient okHttpClient;

    private Map<Integer, Call> callMap;

    private RequestsExecutor(){
        okHttpClient = new OkHttpClient();
        callMap = new LinkedHashMap<>();
    }

    public static RequestsExecutor getInstance() {
        if (instance == null)
            instance = new RequestsExecutor();
        return instance;
    }

    public void execute(ApiRequest request, Callback callback) {
        Call call = okHttpClient.newCall(getAsOkHttpRequest(request));
        callMap.put(request.hashCode(), call);
        try (Response response = execute(request, call)) {
            callback.onResponse(call, response);
        } catch (IOException e) {
            callback.onFailure(call, e);
        } finally {
            callMap.remove(request.hashCode());
        }
    }

    public Response execute(ApiRequest request) throws IOException {
        Call call = okHttpClient.newCall(getAsOkHttpRequest(request));
        return call.execute();
    }

    public void executeEnqueue(ApiRequest request, Callback callback) {
        okHttpClient.newCall(getAsOkHttpRequest(request)).enqueue(callback);
    }

    public void cancel(ApiRequest request) {
        if (callMap.containsKey(request.hashCode())) {
            cancelCall(callMap.get(request.hashCode()));
            callMap.remove(request.hashCode());
        }
    }

    private Response execute(ApiRequest request, Call call) throws IOException {
        callMap.put(request.hashCode(), call);
        try {
            return call.execute();
        } finally {
            callMap.remove(request.hashCode());
        }
    }

    private void cancelCall(Call call) {
        if (call != null && !call.isCanceled() & !call.isExecuted())
            call.cancel();
    }

    private Request getAsOkHttpRequest(ApiRequest request) {
        return new Request.Builder()
                .url(request.asString())
                .build();
    }

}
