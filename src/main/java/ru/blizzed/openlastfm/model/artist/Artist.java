package ru.blizzed.openlastfm.model.artist;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.model.commons.ArrayContainer;
import ru.blizzed.openlastfm.model.commons.Tag;

import java.util.List;


public class Artist extends BaseArtist {

    @SerializedName("ontour")
    private boolean onTour;
    private Stats stats;
    private ArrayContainer<SimilarArtist> similar;
    private ArrayContainer<Tag> tags;
    private Bio bio;

    private Artist() {
    }

    public boolean isOnTour() {
        return onTour;
    }

    public Stats getStats() {
        return stats;
    }

    public Bio getBio() {
        return bio;
    }

    public List<Tag> getTags() {
        return tags.getData();
    }

    public List<SimilarArtist> getSimilarArtists() {
        return similar.getData();
    }

    public static class Stats {

        private int listeners;

        @SerializedName("playcount")
        private int playCount;

        private Stats() {
        }

        public int getListeners() {
            return listeners;
        }

        public int getPlayCount() {
            return playCount;
        }

    }

    public static class Bio {

        private String published;

        private String summary;

        private String content;

        private ArrayContainer<Link> links;

        private Bio() {
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

        public List<Link> getLinks() {
            return links.getData();
        }

    }

}
