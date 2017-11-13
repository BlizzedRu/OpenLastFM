package ru.blizzed.openlastfm.methods;

import com.google.gson.reflect.TypeToken;
import ru.blizzed.openlastfm.models.ObjectModelParser;
import ru.blizzed.openlastfm.models.SearchResult;
import ru.blizzed.openlastfm.models.SearchResultModelParser;
import ru.blizzed.openlastfm.models.SkipRootListModelParser;
import ru.blizzed.openlastfm.models.album.AlbumInfo;
import ru.blizzed.openlastfm.models.album.FoundAlbum;
import ru.blizzed.openlastfm.models.tag.Tag;
import ru.blizzed.openlastfm.models.tag.TopTag;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

public final class ApiAlbum {

    private static final String alias = "Album";

    private ApiAlbum() {
    }

    public static ApiMethod<AlbumInfo> getInfo() {
        return new ApiMethod.Builder<AlbumInfo>(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.ALBUM, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.USERNAME, false),
                        new ApiParamDescription(LastFMParams.LANG, false)
                )
                .buildWithResultModelParser(new ObjectModelParser<>("", AlbumInfo.class));
    }

    public static ApiMethod<List<Tag>> getTags() {
        return new ApiMethod.Builder<List<Tag>>(alias, "getTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.ALBUM, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.USER, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("tag", new TypeToken<List<Tag>>() {
                }));
    }

    public static ApiMethod<List<TopTag>> getTopTags() {
        return new ApiMethod.Builder<List<TopTag>>(alias, "getTopTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.ALBUM, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("tag", new TypeToken<List<TopTag>>() {
                }));
    }

    public static ApiMethod<SearchResult<FoundAlbum>> search() {
        return new ApiMethod.Builder<SearchResult<FoundAlbum>>(alias, "search")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.ALBUM, true)
                )
                .buildWithResultModelParser(new SearchResultModelParser<>(new TypeToken<SearchResult<FoundAlbum>>() {
                }));
    }

}
