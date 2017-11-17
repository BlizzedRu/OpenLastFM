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

package ru.blizzed.openlastfm.models;

import ru.blizzed.openlastfm.methods.ApiParams;
import ru.blizzed.openlastfm.methods.ApiRequest;
import ru.blizzed.openlastfm.params.LastFMParams;
import ru.blizzed.openlastfm.params.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * An interface for building page-like result of some Last.FM API methods
 * <p>E.g. artist.getSimilar, user.getTopAlbums, artist.search, etc
 *
 * @param <ModelType> of expected items type
 */
public interface PaginatedResult<ModelType> {

    int getCurrentPage();

    int getTotalPages();

    default boolean hasNextPage() {
        return getCurrentPage() < getTotalPages();
    }

    /**
     * Returns an {@link ApiRequest} for getting the next page by last (previous) {@link ApiRequest}
     *
     * @param prevRequest last (previous) request whose response is paginated
     * @return next {@link ApiRequest} for getting the next page
     */
    @SuppressWarnings("unchecked")
    default ApiRequest<ModelType> getNextPageRequest(ApiRequest<ModelType> prevRequest) {
        List<Param> params = new ArrayList<>(prevRequest.getParams().asList());
        if (params.contains(LastFMParams.PAGE))
            params.remove(LastFMParams.PAGE);
        params.add(LastFMParams.PAGE.of(getCurrentPage() + 1));
        return new ApiRequest<>(prevRequest.getMethod(), ApiParams.from(params));
    }

}
