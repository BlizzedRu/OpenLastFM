package ru.blizzed.openlastfm.model.artist;

public class SimilarArtist extends BaseArtist {

    private int match;

    public SimilarArtist() {
    }

    public SimilarArtist(String name, String url, String mbid) {
        super(name, url, mbid);
    }

    public int getMatch() {
        return match;
    }

}
