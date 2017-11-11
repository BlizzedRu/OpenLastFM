package ru.blizzed.openlastfm.model.album;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.model.commons.ArrayContainer;
import ru.blizzed.openlastfm.model.commons.Tag;
import ru.blizzed.openlastfm.model.track.BaseTrack;

import java.util.List;

public class Album extends BaseAlbum {

    private long listeners;
    @SerializedName("playcount")
    private long playCount;
    private ArrayContainer<BaseTrack> tracks;
    private ArrayContainer<Tag> tags;
    private Wiki wiki;

    public Album() {
    }

    public long getListeners() {
        return listeners;
    }

    public long getPlayCount() {
        return playCount;
    }

    public List<BaseTrack> getTracks() {
        return tracks.getData();
    }

    public List<Tag> getTags() {
        return tags.getData();
    }

    public Wiki getWiki() {
        return wiki;
    }

    public static class Wiki {

        private String published;

        private String summary;

        private String content;

        public Wiki() {
        }

        public String getPublished() {
            return published;
        }

        public String getSummary() {
            return summary;
        }

        public String getContent() {
            return content;
        }

    }

}
