package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.model.ObjectModelBuilder;
import ru.blizzed.openlastfm.model.artist.Artist;
import ru.blizzed.openlastfm.params.LastFMParams;

public final class ApiArtist {

    private static final String alias = "Artist";

    private ApiArtist() {
    }

    public static ApiMethod getCorrection() {
        return new ApiMethod(alias, "getCorrection")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true)
                );
    }

    public static ApiMethod<Artist> getInfo() {
        return new ApiMethod<Artist>(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.LANG, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.USERNAME, false)
                )
                .setModelBuilder(new ObjectModelBuilder<>("artist", Artist.class));
    }

    public static ApiMethod getSimilar() {
        return new ApiMethod(alias, "getSimilar")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.MBID, false)
                );
    }

    public static ApiMethod getTags() {
        return new ApiMethod(alias, "getTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.USER, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                );
    }

    public static ApiMethod getTopAlbums() {
        return new ApiMethod(alias, "getTopAlbums")
            .addParamsDescriptions(
                    new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                    new ApiParamDescription(LastFMParams.MBID, false),
                    new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                    new ApiParamDescription(LastFMParams.PAGE, false),
                    new ApiParamDescription(LastFMParams.LIMIT, false)
            );
    }

    public static ApiMethod getTopTags() {
        return new ApiMethod(alias, "getTopTags")
            .addParamsDescriptions(
                    new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                    new ApiParamDescription(LastFMParams.MBID, false),
                    new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
            );
    }

    public static ApiMethod getTopTracks() {
        return new ApiMethod(alias, "getTopTracks")
            .addParamsDescriptions(
                    new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                    new ApiParamDescription(LastFMParams.MBID, false),
                    new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                    new ApiParamDescription(LastFMParams.PAGE, false),
                    new ApiParamDescription(LastFMParams.LIMIT, false)
            );
    }

    public static ApiMethod search() {
        return new ApiMethod(alias, "search")
            .addParamsDescriptions(
                    new ApiParamDescription(LastFMParams.LIMIT, false),
                    new ApiParamDescription(LastFMParams.PAGE, false),
                    new ApiParamDescription(LastFMParams.ARTIST, true)
            );
    }


}
