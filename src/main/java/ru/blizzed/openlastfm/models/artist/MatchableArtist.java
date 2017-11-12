package ru.blizzed.openlastfm.models.artist;

public class MatchableArtist extends Artist implements Comparable<MatchableArtist> {

    private double match;

    public double getMatch() {
        return match;
    }

    @Override
    public int compareTo(MatchableArtist o) {
        return Double.compare(getMatch(), o.getMatch());
    }

}
