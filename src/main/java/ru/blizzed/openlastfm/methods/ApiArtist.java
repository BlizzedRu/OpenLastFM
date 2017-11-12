package ru.blizzed.openlastfm.methods;

import com.google.gson.reflect.TypeToken;
import ru.blizzed.openlastfm.models.ObjectModelParser;
import ru.blizzed.openlastfm.models.SkipRootListModelParser;
import ru.blizzed.openlastfm.models.album.TopAlbum;
import ru.blizzed.openlastfm.models.artist.ArtistInfo;
import ru.blizzed.openlastfm.models.artist.MatchableArtist;
import ru.blizzed.openlastfm.models.correction.ArtistCorrection;
import ru.blizzed.openlastfm.models.tag.Tag;
import ru.blizzed.openlastfm.models.tag.TopTag;
import ru.blizzed.openlastfm.models.track.Track;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

public final class ApiArtist {

    private static final String alias = "Artist";

    private ApiArtist() {
    }

    public static ApiMethod<ArtistCorrection> getCorrection() {
        return new ApiMethod.Builder<ArtistCorrection>(alias, "getCorrection")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true)
                )
                .buildWithResultModelParser(new ObjectModelParser<>("correction", ArtistCorrection.class));
    }

    public static ApiMethod<ArtistInfo> getInfo() {
        return new ApiMethod.Builder<ArtistInfo>(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.LANG, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.USERNAME, false)
                )
                .buildWithResultModelParser(new ObjectModelParser<>("artist", ArtistInfo.class));
    }

    public static ApiMethod<List<MatchableArtist>> getSimilar() {
        return new ApiMethod.Builder<List<MatchableArtist>>(alias, "getSimilar")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.MBID, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("artist", new TypeToken<List<MatchableArtist>>() {
                }));
    }

    public static ApiMethod<List<Tag>> getTags() {
        return new ApiMethod.Builder<List<Tag>>(alias, "getTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.USER, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("tag", new TypeToken<List<Tag>>() {
                }));
    }

    public static ApiMethod<List<TopAlbum>> getTopAlbums() {
        return new ApiMethod.Builder<List<TopAlbum>>(alias, "getTopAlbums")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("album", new TypeToken<List<TopAlbum>>() {
                }));
    }

    public static ApiMethod<List<TopTag>> getTopTags() {
        return new ApiMethod.Builder<List<TopTag>>(alias, "getTopTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("tag", new TypeToken<List<TopTag>>() {
                }));
    }

    public static ApiMethod<List<Track>> getTopTracks() {
        return new ApiMethod.Builder<List<Track>>(alias, "getTopTracks")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("track", new TypeToken<List<Track>>() {
                }));
    }

    public static ApiMethod search() {
        return new ApiMethod.Builder<>(alias, "search")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true)
                )
                .buildWithResultModelParser(null);
    }


}
