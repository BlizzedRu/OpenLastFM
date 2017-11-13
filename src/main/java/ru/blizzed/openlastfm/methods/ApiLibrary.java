package ru.blizzed.openlastfm.methods;

import com.google.gson.reflect.TypeToken;
import ru.blizzed.openlastfm.models.PageResult;
import ru.blizzed.openlastfm.models.PaginatedResultModelParser;
import ru.blizzed.openlastfm.models.artist.TaggedArtist;
import ru.blizzed.openlastfm.params.LastFMParams;

public final class ApiLibrary {

    private static final String alias = "Library";

    private ApiLibrary() {
    }

    public static ApiMethod<PageResult<TaggedArtist>> getArtists() {
        return new ApiMethod.Builder<PageResult<TaggedArtist>>(alias, "getArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.USER, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<TaggedArtist>>() {
                }));
    }

}
