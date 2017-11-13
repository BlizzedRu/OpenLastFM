package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.Param;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ApiParams {

    private List<Param> params;

    private ApiParams() {
    }

    public static ApiParams from(Param... params) {
        return from(Arrays.asList(params));
    }

    public static ApiParams from(List<Param> paramList) {
        ApiParams apiParams = new ApiParams();
        apiParams.params = new ArrayList<>(paramList);
        return apiParams;
    }

    public List<Param> asList() {
        return params;
    }

    public boolean isEmpty() {
        return params == null || params.isEmpty();
    }

}
