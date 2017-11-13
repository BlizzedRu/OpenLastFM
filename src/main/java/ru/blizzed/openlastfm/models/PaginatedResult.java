package ru.blizzed.openlastfm.models;

import ru.blizzed.openlastfm.methods.ApiParams;
import ru.blizzed.openlastfm.methods.ApiRequest;
import ru.blizzed.openlastfm.params.LastFMParams;
import ru.blizzed.openlastfm.params.Param;

import java.util.ArrayList;
import java.util.List;

public interface PaginatedResult<ModelType> {

    int getCurrentPage();

    int getTotalPages();

    default boolean hasNextPage() {
        return getCurrentPage() < getTotalPages();
    }

    @SuppressWarnings("unchecked")
    default ApiRequest<ModelType> getNextPageRequest(ApiRequest<ModelType> prevRequest) {
        List<Param> params = new ArrayList<>(prevRequest.getParams().asList());
        if (params.contains(LastFMParams.PAGE))
            params.remove(LastFMParams.PAGE);
        params.add(LastFMParams.PAGE.of(getCurrentPage() + 1));
        return new ApiRequest<>(prevRequest.getMethod(), ApiParams.from(params));
    }

}
