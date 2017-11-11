package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.LastFMParams;

public final class ApiChart {

    private static final String alias = "Chart";

    private ApiChart() {
    }

    public static ApiMethod getTopArtists() {
        return new ApiMethod(alias, "getTopArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                );
    }

    public static ApiMethod getTopTags() {
        return new ApiMethod(alias, "getTopTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                );
    }

    public static ApiMethod getTopTracks() {
        return new ApiMethod(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                );
    }

}
