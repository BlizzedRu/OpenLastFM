package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.Param;

import java.util.*;

public final class ApiParams {

    private List<Param> params;

    private ApiParams() {
    }

    public static ApiParams from(Param... params) {
        ApiParams apiParams = new ApiParams();
        apiParams.params = Arrays.asList(params);
        return apiParams;
    }

    public List<Param> asList() {
        return params;
    }

    public boolean isEmpty() {
        return params == null || params.isEmpty();
    }

}
