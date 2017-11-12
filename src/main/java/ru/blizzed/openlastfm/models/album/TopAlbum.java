package ru.blizzed.openlastfm.models.album;

import ru.blizzed.openlastfm.models.artist.Artist;

public class TopAlbum extends Album {

    private Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public boolean hasArtist() {
        return artist != null;
    }

}
