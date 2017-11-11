package ru.blizzed.openlastfm;

import okhttp3.*;
import ru.blizzed.openlastfm.methods.ApiRequest;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

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
        try (Response response = call.execute()) {
            callback.onResponse(call, response);
        } catch (IOException e) {
            callback.onFailure(call, e);
        } finally {
            callMap.remove(request.hashCode());
        }
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
