package ru.blizzed.openlastfm.models.artist;

import com.google.gson.annotations.SerializedName;

public class TaggedArtist extends Artist {

    @SerializedName("tagcount")
    private int tagCount;

    public int getTagCount() {
        return tagCount;
    }

}
