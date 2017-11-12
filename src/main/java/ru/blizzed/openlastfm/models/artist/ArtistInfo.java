package ru.blizzed.openlastfm.models.artist;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.models.BaseModel;
import ru.blizzed.openlastfm.models.commons.ArrayContainer;
import ru.blizzed.openlastfm.models.commons.Link;

import java.util.Collections;
import java.util.List;

public class ArtistInfo extends BaseModel {

    @SerializedName("ontour")
    private String onTour;

    private Bio bio;
    private ArrayContainer<Artist> similar;

    public boolean iasOnTour() {
        return "1".equals(onTour);
    }

    public Bio getBio() {
        return bio;
    }

    public List<Artist> getSimilar() {
        if (similar == null) return Collections.emptyList();
        return similar.getData();
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
