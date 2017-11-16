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
import ru.blizzed.openlastfm.models.album.TopAlbum;
import ru.blizzed.openlastfm.models.artist.ArtistInfo;
import ru.blizzed.openlastfm.models.artist.FoundArtist;
import ru.blizzed.openlastfm.models.artist.MatchableArtist;
import ru.blizzed.openlastfm.models.correction.ArtistCorrection;
import ru.blizzed.openlastfm.models.tag.Tag;
import ru.blizzed.openlastfm.models.tag.TopTag;
import ru.blizzed.openlastfm.models.track.Track;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

/**
 * This class provides available methods of section "Artist"
 *
 * @author BlizzedRu (Ivan Vlasov)
 */
public final class ApiArtist {

    private static final String alias = "Artist";

    private ApiArtist() {
    }

    public static ApiMethod<ArtistCorrection> getCorrection() {
        return new ApiMethod.Builder<ArtistCorrection>(alias, "getCorrection")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true)
                )
                .buildWithResultModelParser(new ObjectModelParser<>("correction", ArtistCorrection.class));
    }

    public static ApiMethod<ArtistInfo> getInfo() {
        return new ApiMethod.Builder<ArtistInfo>(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.LANG, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.USERNAME, false)
                )
                .buildWithResultModelParser(new ObjectModelParser<>("artist", ArtistInfo.class));
    }

    public static ApiMethod<List<MatchableArtist>> getSimilar() {
        return new ApiMethod.Builder<List<MatchableArtist>>(alias, "getSimilar")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.MBID, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("artist", new TypeToken<List<MatchableArtist>>() {
                }));
    }

    public static ApiMethod<List<Tag>> getTags() {
        return new ApiMethod.Builder<List<Tag>>(alias, "getTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.USER, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("tag", new TypeToken<List<Tag>>() {
                }));
    }

    public static ApiMethod<PageResult<TopAlbum>> getTopAlbums() {
        return new ApiMethod.Builder<PageResult<TopAlbum>>(alias, "getTopAlbums")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<TopAlbum>>() {
                }));
    }

    public static ApiMethod<PageResult<TopTag>> getTopTags() {
        return new ApiMethod.Builder<PageResult<TopTag>>(alias, "getTopTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<TopTag>>() {
                }));
    }

    public static ApiMethod<PageResult<Track>> getTopTracks() {
        return new ApiMethod.Builder<PageResult<Track>>(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<Track>>() {
                }));
    }

    public static ApiMethod<SearchResult<FoundArtist>> search() {
        return new ApiMethod.Builder<SearchResult<FoundArtist>>(alias, "search")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<SearchResult<FoundArtist>>() {
                }));
    }


}
