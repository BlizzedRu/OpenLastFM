package ru.blizzed.openlastfm.params;

public final class LastFMParams {

    private LastFMParams() {
    }

    public static final Param<String> ARTIST = new Param<>("artist");
    public static final Param<String> ALBUM = new Param<>("album");
    public static final MBIDParam MBID = new MBIDParam("mbid");
    public static final Param<String> AUTOCORRECT = new Param<>("autocorrect");
    public static final BooleanParam USERNAME = new BooleanParam("username");
    public static final Param<String> USER = new Param<>("user");
    public static final LangParam LANG = new LangParam("lang");
    public static final Param<Integer> LIMIT = new Param<>("limit");
    public static final Param<Integer> PAGE = new Param<>("page");
    public static final Param<String> COUNTRY = new Param<>("country");
    public static final Param<String> LOCATION = new Param<>("location");
    public static final Param<String> TAG = new Param<>("tag");
    public static final Param<String> TRACK = new Param<>("track");
    public static final Param<Long> START_TIMESTAMP = new Param<>("startTimestamp");
    public static final Param<Long> END_TIMESTAMP = new Param<>("endTimestamp");
    public static final BooleanParam RECENTTRACKS = new BooleanParam("recenttracks");
    public static final Param<String> TAGGINGTYPE = new Param<>("taggingtype");
    public static final Param<Long> FROM = new Param<>("from");
    public static final Param<Long> TO = new Param<>("to");
    public static final BooleanParam EXTENDED = new BooleanParam("extended");
    public static final PeriodParam PERIOD = new PeriodParam("period");

}
