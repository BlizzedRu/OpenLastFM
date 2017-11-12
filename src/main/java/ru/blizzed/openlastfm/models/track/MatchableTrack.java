package ru.blizzed.openlastfm.models.track;

public class MatchableTrack extends Track implements Comparable<MatchableTrack> {

    private double match;

    public double getMatch() {
        return match;
    }

    @Override
    public int compareTo(MatchableTrack o) {
        return Double.compare(getMatch(), o.getMatch());
    }

}
