package ru.blizzed.openlastfm.models.tag;

public class TopTag extends Tag {

    private long reach = DEF_VALUE;
    private long taggings = DEF_VALUE;
    private String streamable;

    public long getReach() {
        return reach;
    }

    public long getTaggings() {
        return taggings;
    }

    public boolean isStreamable() {
        return "1".equals(streamable);
    }

    public boolean hasTaggings() {
        return taggings != DEF_VALUE;
    }

    public boolean hasReach() {
        return reach != DEF_VALUE;
    }

}
