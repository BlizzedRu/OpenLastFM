package ru.blizzed.openlastfm.model.album;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.model.commons.Image;

import java.util.List;

public class BaseAlbum {

    private String artist;
    private String title;
    private String mbid;
    private String url;
    @SerializedName("image")
    private List<Image> images;

    BaseAlbum() {
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public List<Image> getImages() {
        return images;
    }
}
