package ru.blizzed.openlastfm.model.artist;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.model.commons.Image;

import java.util.List;

public class BaseArtist {

    private String name;
    private String url;
    private String mbid;

    @SerializedName("image")
    private List<Image> images;

    BaseArtist() {
    }

    BaseArtist(String name, String url, String mbid) {
        this.name = name;
        this.url = url;
        this.mbid = mbid;
    }


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getMbid() {
        return mbid;
    }

    public List<Image> getImages() {
        return images;
    }

    public boolean hasImages() {
        return images != null;
    }

}
