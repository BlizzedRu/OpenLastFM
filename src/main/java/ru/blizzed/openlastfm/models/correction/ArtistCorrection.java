package ru.blizzed.openlastfm.models.correction;

import ru.blizzed.openlastfm.models.artist.Artist;

public class ArtistCorrection {

    private Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public boolean isCorrected() {
        return artist != null;
    }

}
