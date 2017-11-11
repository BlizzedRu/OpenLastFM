package ru.blizzed.openlastfm.model.track;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.model.album.Album;

public class Track extends BaseTrack {

    private String mbid;
    private int listeners;

    @SerializedName("playcount")
    private int playCount;

    private Album album;

    public String getMbid() {
        return mbid;
    }

    public int getListeners() {
        return listeners;
    }

    public int getPlayCount() {
        return playCount;
    }

    public Album getAlbum() {
        return album;
    }
}
