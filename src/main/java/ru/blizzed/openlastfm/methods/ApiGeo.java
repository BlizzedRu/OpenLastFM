package ru.blizzed.openlastfm.methods;

import com.google.gson.reflect.TypeToken;
import ru.blizzed.openlastfm.models.SkipRootListModelParser;
import ru.blizzed.openlastfm.models.artist.Artist;
import ru.blizzed.openlastfm.models.track.Track;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

public final class ApiGeo {

    private static final String alias = "Geo";

    private ApiGeo() {
    }

    public static ApiMethod<List<Artist>> getTopArtists() {
        return new ApiMethod.Builder<List<Artist>>(alias, "getTopArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.COUNTRY, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("artist", new TypeToken<List<Artist>>() {
                }));
    }

    public static ApiMethod<List<Track>> getTopTracks() {
        return new ApiMethod.Builder<List<Track>>(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.COUNTRY, true),
                        new ApiParamDescription(LastFMParams.LOCATION, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("track", new TypeToken<List<Track>>() {
                }));
    }

}
