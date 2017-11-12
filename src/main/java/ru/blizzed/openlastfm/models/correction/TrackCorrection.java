package ru.blizzed.openlastfm.models.correction;

import ru.blizzed.openlastfm.models.track.Track;

public class TrackCorrection {

    private Track track;

    public Track getTrack() {
        return track;
    }

    public boolean isCorrected() {
        return track != null;
    }

}
