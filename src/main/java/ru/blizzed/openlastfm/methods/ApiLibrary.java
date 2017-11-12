package ru.blizzed.openlastfm.methods;

import com.google.gson.reflect.TypeToken;
import ru.blizzed.openlastfm.models.SkipRootListModelParser;
import ru.blizzed.openlastfm.models.artist.TaggedArtist;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

public final class ApiLibrary {

    private static final String alias = "Library";

    private ApiLibrary() {
    }

    public static ApiMethod<List<TaggedArtist>> getArtists() {
        return new ApiMethod.Builder<List<TaggedArtist>>(alias, "getArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("artist", new TypeToken<List<TaggedArtist>>() {
                }));
    }

}
