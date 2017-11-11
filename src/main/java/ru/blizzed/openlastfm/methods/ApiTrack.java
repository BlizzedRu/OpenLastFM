package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.LastFMParams;

public final class ApiTrack {

    private static final String alias = "Track";

    private ApiTrack() {
    }

    public static ApiMethod getCorrection() {
        return new ApiMethod(alias, "getCorrection")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true),
                        new ApiParamDescription(LastFMParams.TRACK, true)
                );
    }

    public static ApiMethod getInfo() {
        return new ApiMethod(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.USERNAME, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                );
    }

    public static ApiMethod getSimilar() {
        return new ApiMethod(alias, "getSimilar")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                );
    }

    public static ApiMethod getTags() {
        return new ApiMethod(alias, "getTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.USER, false)
                );
    }

    public static ApiMethod getTopTags() {
        return new ApiMethod(alias, "getTopTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                );
    }

    public static ApiMethod search() {
        return new ApiMethod(alias, "search")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.TRACK, true),
                        new ApiParamDescription(LastFMParams.ARTIST, false)
                );
    }

}
