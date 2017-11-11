package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.LastFMParams;

public final class ApiTag {

    private static final String alias = "Tag";

    private ApiTag() {
    }

    public static ApiMethod getInfo() {
        return new ApiMethod(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LANG, false),
                        new ApiParamDescription(LastFMParams.TAG, true)
                );

    }

    public static ApiMethod getSimilar() {
        return new ApiMethod(alias, "getSimilar")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.TAG, true)
                );

    }

    public static ApiMethod getTopAlbums() {
        return new ApiMethod(alias, "getTopAlbums")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.TAG, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LANG, false)
                );

    }

    public static ApiMethod getTopArtists() {
        return new ApiMethod(alias, "getTopArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.TAG, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LANG, false)
                );
    }

    public static ApiMethod getTopTags() {
        return new ApiMethod(alias, "getTopTags")
                .addParamsDescriptions();
    }


    public static ApiMethod getTopTracks() {
        return new ApiMethod(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.TAG, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LANG, false)
                );
    }

    public static ApiMethod getWeeklyChartList() {
        return new ApiMethod(alias, "getWeeklyChartList")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.TAG, true)
                );
    }

}
