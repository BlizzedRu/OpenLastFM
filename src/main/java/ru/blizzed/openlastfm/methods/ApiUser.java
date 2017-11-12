package ru.blizzed.openlastfm.methods;

import com.google.gson.reflect.TypeToken;
import ru.blizzed.openlastfm.models.ObjectModelParser;
import ru.blizzed.openlastfm.models.SkipRootListModelParser;
import ru.blizzed.openlastfm.models.User;
import ru.blizzed.openlastfm.models.album.Album;
import ru.blizzed.openlastfm.models.album.TopAlbum;
import ru.blizzed.openlastfm.models.artist.Artist;
import ru.blizzed.openlastfm.models.commons.Chart;
import ru.blizzed.openlastfm.models.tag.TopTag;
import ru.blizzed.openlastfm.models.track.DateTrack;
import ru.blizzed.openlastfm.models.track.Track;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

public final class ApiUser {

    private static final String alias = "User";

    private ApiUser() {
    }

    public static ApiMethod<List<DateTrack>> getArtistTracks() {
        return new ApiMethod.Builder<List<DateTrack>>(alias, "getArtistTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.ARTIST, true),
                        new ApiParamDescription(LastFMParams.START_TIMESTAMP, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.END_TIMESTAMP, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("track", new TypeToken<List<DateTrack>>() {
                }));
    }

    public static ApiMethod<List<User>> getFriends() {
        return new ApiMethod.Builder<List<User>>(alias, "getFriends")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.RECENTTRACKS, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("user", new TypeToken<List<User>>() {
                }));
    }

    public static ApiMethod<User> getInfo() {
        return new ApiMethod.Builder<User>(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, false)
                )
                .buildWithResultModelParser(new ObjectModelParser<>("", User.class));
    }

    public static ApiMethod<List<DateTrack>> getLovedTracks() {
        return new ApiMethod.Builder<List<DateTrack>>(alias, "getLovedTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("track", new TypeToken<List<DateTrack>>() {
                }));
    }

    public static ApiMethod<List<Artist>> getPersonalTags() {
        return new ApiMethod.Builder<List<Artist>>(alias, "getPersonalTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.TAG, true),
                        new ApiParamDescription(LastFMParams.TAGGINGTYPE, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("artist", new TypeToken<List<Artist>>() {
                }));
    }

    public static ApiMethod<List<DateTrack>> getRecentTracks() {
        return new ApiMethod.Builder<List<DateTrack>>(alias, "getRecentTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.FROM, false),
                        new ApiParamDescription(LastFMParams.EXTENDED, false),
                        new ApiParamDescription(LastFMParams.TO, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("track", new TypeToken<List<DateTrack>>() {
                }));
    }

    public static ApiMethod<List<TopAlbum>> getTopAlbums() {
        return new ApiMethod.Builder<List<TopAlbum>>(alias, "getTopAlbums")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PERIOD, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("album", new TypeToken<List<TopAlbum>>() {
                }));
    }

    public static ApiMethod<List<Artist>> getTopArtists() {
        return new ApiMethod.Builder<List<Artist>>(alias, "getTopArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PERIOD, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("artist", new TypeToken<List<Artist>>() {
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

    public static ApiMethod<List<Track>> getTopTracks() {
        return new ApiMethod.Builder<List<Track>>(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PERIOD, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("track", new TypeToken<List<Track>>() {
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
