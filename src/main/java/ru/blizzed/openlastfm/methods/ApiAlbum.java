package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.model.ListModelBuilder;
import ru.blizzed.openlastfm.model.ObjectModelBuilder;
import ru.blizzed.openlastfm.model.commons.Tag;
import ru.blizzed.openlastfm.model.album.Album;
import ru.blizzed.openlastfm.model.artist.Artist;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

public final class ApiAlbum {

    private static final String alias = "Album";

    private ApiAlbum() {
    }

    public static ApiMethod<Album> getInfo() {
        return new ApiMethod<Album>(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.ALBUM, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.USERNAME, false),
                        new ApiParamDescription(LastFMParams.LANG, false)
                )
                .setModelBuilder(new ObjectModelBuilder<>("", Album.class));
    }

    public static ApiMethod<List<Tag>> getTags() {
        return new ApiMethod<List<Tag>>(alias, "getTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.ALBUM, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.USER, false)
                )
                .setModelBuilder(new ListModelBuilder<>("tag"));
    }

    public static ApiMethod<List<Tag>> getTopTags() {
        return new ApiMethod<List<Tag>>(alias, "getTopTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.ALBUM, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                );
    }

    public static ApiMethod<List<Artist>> search() {
        return new ApiMethod<List<Artist>>(alias, "search")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.ALBUM, true)
                );
    }

}
