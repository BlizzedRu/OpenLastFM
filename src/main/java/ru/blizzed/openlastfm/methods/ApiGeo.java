package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.LastFMParams;

public final class ApiGeo {

    private static final String alias = "Geo";

    private ApiGeo() {
    }

    public static ApiMethod getTopArtists() {
        return new ApiMethod(alias, "getTopArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.COUNTRY, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                );
    }

    public static ApiMethod getTopTracks() {
        return new ApiMethod(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.COUNTRY, true),
                        new ApiParamDescription(LastFMParams.LOCATION, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                );
    }

}
