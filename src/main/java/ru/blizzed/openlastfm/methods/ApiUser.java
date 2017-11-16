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
import ru.blizzed.openlastfm.models.ObjectModelParser;
import ru.blizzed.openlastfm.models.PageResult;
import ru.blizzed.openlastfm.models.PaginatedResultModelParser;
import ru.blizzed.openlastfm.models.SkipRootListModelParser;
import ru.blizzed.openlastfm.models.album.Album;
import ru.blizzed.openlastfm.models.album.TopAlbum;
import ru.blizzed.openlastfm.models.artist.Artist;
import ru.blizzed.openlastfm.models.commons.Chart;
import ru.blizzed.openlastfm.models.commons.User;
import ru.blizzed.openlastfm.models.tag.TopTag;
import ru.blizzed.openlastfm.models.track.DateTrack;
import ru.blizzed.openlastfm.models.track.Track;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

/**
 * This class provides available methods of section "User"
 *
 * @author BlizzedRu (Ivan Vlasov)
 */
public final class ApiUser {

    private static final String alias = "User";

    private ApiUser() {
    }

    public static ApiMethod<PageResult<DateTrack>> getArtistTracks() {
        return new ApiMethod.Builder<PageResult<DateTrack>>(alias, "getArtistTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.ARTIST, true),
                        new ApiParamDescription(LastFMParams.START_TIMESTAMP, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.END_TIMESTAMP, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<DateTrack>>() {
                }));
    }

    public static ApiMethod<PageResult<User>> getFriends() {
        return new ApiMethod.Builder<PageResult<User>>(alias, "getFriends")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.RECENTTRACKS, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<User>>() {
                }));
    }

    public static ApiMethod<User> getInfo() {
        return new ApiMethod.Builder<User>(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, false)
                )
                .buildWithResultModelParser(new ObjectModelParser<>("", User.class));
    }

    public static ApiMethod<PageResult<DateTrack>> getLovedTracks() {
        return new ApiMethod.Builder<PageResult<DateTrack>>(alias, "getLovedTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<DateTrack>>() {
                }));
    }

    public static ApiMethod<PageResult<Artist>> getPersonalTags() {
        return new ApiMethod.Builder<PageResult<Artist>>(alias, "getPersonalTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.TAG, true),
                        new ApiParamDescription(LastFMParams.TAGGINGTYPE, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<Artist>>() {
                }));
    }

    public static ApiMethod<PageResult<DateTrack>> getRecentTracks() {
        return new ApiMethod.Builder<PageResult<DateTrack>>(alias, "getRecentTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.FROM, false),
                        new ApiParamDescription(LastFMParams.EXTENDED, false),
                        new ApiParamDescription(LastFMParams.TO, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<DateTrack>>() {
                }));
    }

    public static ApiMethod<PageResult<TopAlbum>> getTopAlbums() {
        return new ApiMethod.Builder<PageResult<TopAlbum>>(alias, "getTopAlbums")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PERIOD, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<TopAlbum>>() {
                }));
    }

    public static ApiMethod<PageResult<Artist>> getTopArtists() {
        return new ApiMethod.Builder<PageResult<Artist>>(alias, "getTopArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PERIOD, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<Artist>>() {
                }));
    }

    public static ApiMethod<List<TopTag>> getTopTags() {
        return new ApiMethod.Builder<List<TopTag>>(alias, "getTopTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("tag", new TypeToken<List<TopTag>>() {
                }));
    }

    public static ApiMethod<PageResult<Track>> getTopTracks() {
        return new ApiMethod.Builder<PageResult<Track>>(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PERIOD, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<Track>>() {
                }));
    }

    public static ApiMethod<List<Album>> getWeeklyAlbumChart() {
        return new ApiMethod.Builder<List<Album>>(alias, "getWeeklyAlbumChart")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.FROM, false),
                        new ApiParamDescription(LastFMParams.TO, false)
                ).buildWithResultModelParser(new SkipRootListModelParser<>("album", new TypeToken<List<Album>>() {
                }));
    }

    public static ApiMethod<List<Artist>> getWeeklyArtistChart() {
        return new ApiMethod.Builder<List<Artist>>(alias, "getWeeklyArtistChart")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.FROM, false),
                        new ApiParamDescription(LastFMParams.TO, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("artist", new TypeToken<List<Artist>>() {
                }));
    }

    public static ApiMethod<List<Chart>> getWeeklyChartList() {
        return new ApiMethod.Builder<List<Chart>>(alias, "getWeeklyChartList")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("chart", new TypeToken<List<Chart>>() {
                }));
    }

    public static ApiMethod<List<Track>> getWeeklyTrackChart() {
        return new ApiMethod.Builder<List<Track>>(alias, "getWeeklyTrackChart")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.FROM, false),
                        new ApiParamDescription(LastFMParams.TO, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("track", new TypeToken<List<Track>>() {
                }));
    }

}
