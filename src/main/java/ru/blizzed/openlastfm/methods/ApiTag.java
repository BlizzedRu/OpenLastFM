package ru.blizzed.openlastfm.methods;

import com.google.gson.reflect.TypeToken;
import ru.blizzed.openlastfm.models.PageResult;
import ru.blizzed.openlastfm.models.PaginatedResultModelParser;
import ru.blizzed.openlastfm.models.SkipRootListModelParser;
import ru.blizzed.openlastfm.models.SkipRootObjectModelParser;
import ru.blizzed.openlastfm.models.album.TopAlbum;
import ru.blizzed.openlastfm.models.artist.Artist;
import ru.blizzed.openlastfm.models.commons.Chart;
import ru.blizzed.openlastfm.models.tag.Tag;
import ru.blizzed.openlastfm.models.tag.TopTag;
import ru.blizzed.openlastfm.models.track.Track;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

public final class ApiTag {

    private static final String alias = "Tag";

    private ApiTag() {
    }

    public static ApiMethod<Tag> getInfo() {
        return new ApiMethod.Builder<Tag>(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LANG, false),
                        new ApiParamDescription(LastFMParams.TAG, true)
                )
                .buildWithResultModelParser(new SkipRootObjectModelParser<>("", Tag.class));

    }

    public static ApiMethod<List<TopTag>> getSimilar() {
        return new ApiMethod.Builder<List<TopTag>>(alias, "getSimilar")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.TAG, true)
                ).buildWithResultModelParser(new SkipRootListModelParser<>("tag", new TypeToken<List<TopTag>>() {
                }));

    }

    public static ApiMethod<PageResult<TopAlbum>> getTopAlbums() {
        return new ApiMethod.Builder<PageResult<TopAlbum>>(alias, "getTopAlbums")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.TAG, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LANG, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<TopAlbum>>() {
                }));

    }

    public static ApiMethod<PageResult<Artist>> getTopArtists() {
        return new ApiMethod.Builder<PageResult<Artist>>(alias, "getTopArtists")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.TAG, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LANG, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<Artist>>() {
                }));
    }

    public static ApiMethod<PageResult<TopTag>> getTopTags() {
        return new ApiMethod.Builder<PageResult<TopTag>>(alias, "getTopTags")
                .addParamsDescriptions()
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<TopTag>>() {
                }));
    }


    public static ApiMethod<PageResult<Track>> getTopTracks() {
        return new ApiMethod.Builder<PageResult<Track>>(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.TAG, true),
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LANG, false)
                )
                .buildWithResultModelParser(new PaginatedResultModelParser<>(new TypeToken<PageResult<Track>>() {
                }));
    }

    public static ApiMethod<List<Chart>> getWeeklyChartList() {
        return new ApiMethod.Builder<List<Chart>>(alias, "getWeeklyChartList")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.TAG, true)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("chart", new TypeToken<List<Chart>>() {
                }));
    }

}
