package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.LastFMParams;

public final class ApiLibrary {

    private static final String alias = "Library";

    private ApiLibrary() {
    }

    public static ApiMethod getArtists() {
        return new ApiMethod(alias, "getArtists.json")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                );
    }

}
