package ru.blizzed.openlastfm.methods;

import com.google.gson.reflect.TypeToken;
import ru.blizzed.openlastfm.models.SkipRootListModelParser;
import ru.blizzed.openlastfm.models.artist.Artist;
import ru.blizzed.openlastfm.models.tag.TopTag;
import ru.blizzed.openlastfm.models.track.Track;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

public final class ApiChart {

    private static final String alias = "Chart";

    private ApiChart() {
    }

    public static ApiMethod<List<Artist>> getTopArtists() {
        return new ApiMethod.Builder<List<Artist>>(alias, "getTopArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("artist", new TypeToken<List<Artist>>() {
                }));
    }

    public static ApiMethod<List<TopTag>> getTopTags() {
        return new ApiMethod.Builder<List<TopTag>>(alias, "getTopTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("tag", new TypeToken<List<TopTag>>() {
                }));
    }

    public static ApiMethod<List<Track>> getTopTracks() {
        return new ApiMethod.Builder<List<Track>>(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("track", new TypeToken<List<Track>>() {
                }));
    }

}
