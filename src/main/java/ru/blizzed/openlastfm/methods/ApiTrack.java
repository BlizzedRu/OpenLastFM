package ru.blizzed.openlastfm.methods;

import com.google.gson.reflect.TypeToken;
import ru.blizzed.openlastfm.models.SkipRootListModelParser;
import ru.blizzed.openlastfm.models.SkipRootObjectModelParser;
import ru.blizzed.openlastfm.models.correction.TrackCorrection;
import ru.blizzed.openlastfm.models.tag.Tag;
import ru.blizzed.openlastfm.models.track.MatchableTrack;
import ru.blizzed.openlastfm.models.track.Track;
import ru.blizzed.openlastfm.params.LastFMParams;

import java.util.List;

public final class ApiTrack {

    private static final String alias = "Track";

    private ApiTrack() {
    }

    public static ApiMethod<List<TrackCorrection>> getCorrection() {
        return new ApiMethod.Builder<List<TrackCorrection>>(alias, "getCorrection")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true),
                        new ApiParamDescription(LastFMParams.TRACK, true)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("correction", new TypeToken<List<TrackCorrection>>() {
                }));
    }

    public static ApiMethod<Track> getInfo() {
        return new ApiMethod.Builder<Track>(alias, "getInfo")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.USERNAME, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                )
                .buildWithResultModelParser(new SkipRootObjectModelParser<>("", Track.class));
    }

    public static ApiMethod<List<MatchableTrack>> getSimilar() {
        return new ApiMethod.Builder<List<MatchableTrack>>(alias, "getSimilar")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.LIMIT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("track", new TypeToken<List<MatchableTrack>>() {
                }));
    }

    public static ApiMethod<List<Tag>> getTags() {
        return new ApiMethod.Builder<List<Tag>>(alias, "getTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false),
                        new ApiParamDescription(LastFMParams.USER, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("tag", new TypeToken<List<Tag>>() {
                }));
    }

    public static ApiMethod<List<Tag>> getTopTags() {
        return new ApiMethod.Builder<List<Tag>>(alias, "getTopTags")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.TRACK, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                )
                .buildWithResultModelParser(new SkipRootListModelParser<>("tag", new TypeToken<List<Tag>>() {
                }));
    }

    public static ApiMethod search() {
        return new ApiMethod.Builder(alias, "search")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.LIMIT, false),
                        new ApiParamDescription(LastFMParams.PAGE, false),
                        new ApiParamDescription(LastFMParams.TRACK, true),
                        new ApiParamDescription(LastFMParams.ARTIST, false)
                )
                .buildWithResultModelParser(null);
    }

}
