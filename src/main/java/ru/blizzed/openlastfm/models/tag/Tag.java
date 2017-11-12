package ru.blizzed.openlastfm.models.tag;

public class Tag {

    protected static final int DEF_VALUE = -1;

    private String name;
    private String url;
    private int count = DEF_VALUE;
    private Wiki wiki;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getCount() {
        return count;
    }

    public Wiki getWiki() {
        return wiki;
    }

    public boolean hasWiki() {
        return wiki != null;
    }

    public static class Wiki {

        private String summary;
        private String content;

        public String getSummary() {
            return summary;
        }

        public String getContent() {
            return content;
        }
    }

}
