package ru.blizzed.openlastfm.models.commons;

import com.google.gson.annotations.SerializedName;

public class Date {

    @SerializedName("#text")
    private String text;

    @SerializedName(value = "unixtime", alternate = {"uts"})
    private long unixtime;

    public String getText() {
        return text;
    }

    public long getUnixtime() {
        return unixtime;
    }

}
