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

import com.google.gson.reflect.TypeToken;
import ru.blizzed.openlastfm.models.PageResult;
import ru.blizzed.openlastfm.models.PaginatedResultModelParser;
import ru.blizzed.openlastfm.models.artist.Artist;
import ru.blizzed.openlastfm.models.track.Track;
import ru.blizzed.openlastfm.params.LastFMParams;

/**
 * This class provides available methods of section "Geo"
 *
 * @author BlizzedRu (Ivan Vlasov)
 */
public final class ApiGeo {

    private static final String alias = "Geo";

    private ApiGeo() {
    }

    public static ApiMethod<PageResult<Artist>> getTopArtists() {
        return new ApiMethod.Builder<PageResult<Artist>>(alias, "getTopArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.COUNTRY, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<Artist>>() {
                }));
    }

    public static ApiMethod<PageResult<Track>> getTopTracks() {
        return new ApiMethod.Builder<PageResult<Track>>(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.COUNTRY, true),
                        new ApiParamDescription(LastFMParams.LOCATION, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<Track>>() {
                }));
    }

}
