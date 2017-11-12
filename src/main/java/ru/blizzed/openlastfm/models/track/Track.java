package ru.blizzed.openlastfm.models.track;

import ru.blizzed.openlastfm.models.BaseModel;
import ru.blizzed.openlastfm.models.album.Album;
import ru.blizzed.openlastfm.models.artist.Artist;

public class Track extends BaseModel {

    private Artist artist;
    private int duration = DEF_VALUE;
    private Album album;

    public Artist getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public Album getAlbum() {
        return album;
    }

    public boolean hasDuration() {
        return duration != DEF_VALUE;
    }

    public boolean hasAlbum() {
        return album != null;
    }

}
