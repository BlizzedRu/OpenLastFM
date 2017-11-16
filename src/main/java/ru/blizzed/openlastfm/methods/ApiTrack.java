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
import ru.blizzed.openlastfm.models.*;
import ru.blizzed.openlastfm.models.correction.TrackCorrection;
import ru.blizzed.openlastfm.models.tag.Tag;
import ru.blizzed.openlastfm.models.track.FoundTrack;
import ru.blizzed.openlastfm.models.track.MatchableTrack;
import ru.blizzed.openlastfm.models.track.Track;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

/**
 * This class provides available methods of section "Track"
 *
 * @author BlizzedRu (Ivan Vlasov)
 */
public final class ApiTrack {

    private static final String alias = "Track";

    private ApiTrack() {
    }

    public static ApiMethod<List<TrackCorrection>> getCorrection() {
        return new ApiMethod.Builder<List<TrackCorrection>>(alias, "getCorrection")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true),
                        new ApiParamDescription(LastFMParams.TRACK, true)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("correction", new TypeToken<List<TrackCorrection>>() {
                }));
    }

    public static ApiMethod<Track> getInfo() {
        return new ApiMethod.Builder<Track>(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.USERNAME, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                )
                .buildWithResultModelParser(new SkipRootObjectModelParser<>("", Track.class));
    }

    public static ApiMethod<List<MatchableTrack>> getSimilar() {
        return new ApiMethod.Builder<List<MatchableTrack>>(alias, "getSimilar")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("track", new TypeToken<List<MatchableTrack>>() {
                }));
    }

    public static ApiMethod<List<Tag>> getTags() {
        return new ApiMethod.Builder<List<Tag>>(alias, "getTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.USER, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("tag", new TypeToken<List<Tag>>() {
                }));
    }

    public static ApiMethod<PageResult<Tag>> getTopTags() {
        return new ApiMethod.Builder<PageResult<Tag>>(alias, "getTopTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<Tag>>() {
                }));
    }

    public static ApiMethod<SearchResult<FoundTrack>> search() {
        return new ApiMethod.Builder<SearchResult<FoundTrack>>(alias, "search")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.TRACK, true),
                        new ApiParamDescription(LastFMParams.ARTIST, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<SearchResult<FoundTrack>>() {
                }));
    }

}
