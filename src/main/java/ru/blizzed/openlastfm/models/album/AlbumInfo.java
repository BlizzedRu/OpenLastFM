package ru.blizzed.openlastfm.models.album;

import ru.blizzed.openlastfm.models.commons.ArrayContainer;
import ru.blizzed.openlastfm.models.track.Track;

import java.util.List;

public class AlbumInfo extends Album {

    private ArrayContainer<Track> tracks;
    private Wiki wiki;
    private String artist;

    public String getArtist() {
        return artist;
    }

    public Wiki getWiki() {
        return wiki;
    }

    public List<Track> getTracks() {
        return tracks.getData();
    }

    public boolean hasTracks() {
        return tracks != null && !tracks.getData().isEmpty();
    }

    public static class Wiki {
        private String published;
        private String summary;
        private String content;

        Wiki() {
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
