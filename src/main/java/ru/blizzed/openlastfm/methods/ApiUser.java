package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.LastFMParams;

public final class ApiUser {

    private static final String alias = "User";

    private ApiUser() {
    }

    public static ApiMethod getArtistTracks() {
        return new ApiMethod(alias, "getArtistTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.ARTIST, true),
                        new ApiParamDescription(LastFMParams.START_TIMESTAMP, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.END_TIMESTAMP, false)
                );
    }

    public static ApiMethod getFriends() {
        return new ApiMethod(alias, "getFriends")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.RECENTTRACKS, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                );
    }

    public static ApiMethod getInfo() {
        return new ApiMethod(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, false)
                );
    }

    public static ApiMethod getLovedTracks() {
        return new ApiMethod(alias, "getLovedTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                );
    }

    public static ApiMethod getPersonalTags() {
        return new ApiMethod(alias, "getPersonalTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.TAG, true),
                        new ApiParamDescription(LastFMParams.TAGGINGTYPE, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                );
    }

    public static ApiMethod getRecentTracks() {
        return new ApiMethod(alias, "getRecentTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.FROM, false),
                        new ApiParamDescription(LastFMParams.EXTENDED, false),
                        new ApiParamDescription(LastFMParams.TO, false)
                );
    }

    public static ApiMethod getTopAlbums() {
        return new ApiMethod(alias, "getTopAlbums")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PERIOD, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                );
    }

    public static ApiMethod getTopArtists() {
        return new ApiMethod(alias, "getTopArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PERIOD, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                );
    }

    public static ApiMethod getTopTags() {
        return new ApiMethod(alias, "getTopTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                );
    }

    public static ApiMethod getTopTracks() {
        return new ApiMethod(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.PERIOD, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                );
    }

    public static ApiMethod getWeeklyAlbumChart() {
        return new ApiMethod(alias, "getWeeklyAlbumChart")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.FROM, false),
                        new ApiParamDescription(LastFMParams.TO, false)
                );
    }

    public static ApiMethod getWeeklyArtistChart() {
        return new ApiMethod(alias, "getWeeklyArtistChart")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.FROM, false),
                        new ApiParamDescription(LastFMParams.TO, false)
                );
    }

    public static ApiMethod getWeeklyChartList() {
        return new ApiMethod(alias, "getWeeklyChartList")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true)
                );
    }

    public static ApiMethod getWeeklyTrackChart() {
        return new ApiMethod(alias, "getWeeklyTrackChart")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.FROM, false),
                        new ApiParamDescription(LastFMParams.TO, false)
                );
    }

}
