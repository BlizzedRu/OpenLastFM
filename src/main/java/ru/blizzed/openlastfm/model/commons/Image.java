package ru.blizzed.openlastfm.model.commons;

import com.google.gson.annotations.SerializedName;

public class Image {

    public enum Size {
        @SerializedName("small")
        SMALL,

        @SerializedName("medium")
        MEDIUM,

        @SerializedName("large")
        LARGE,

        @SerializedName("extralarge")
        EXTRALARGE,

        @SerializedName("mega")
        MEGA,

        @SerializedName("")
        DEFAULT
    }

    @SerializedName("#text")
    private String url;

    @SerializedName("size")
    private Size size;

    public String getUrl() {
        return url;
    }

    public Size getSize() {
        return size;
    }

}
