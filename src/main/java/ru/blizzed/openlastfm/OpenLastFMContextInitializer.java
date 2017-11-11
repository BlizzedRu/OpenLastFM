package ru.blizzed.openlastfm;

import com.sun.istack.internal.NotNull;

public interface OpenLastFMContextInitializer {

    @NotNull
    default String getVersion() {
        return "2.0";
    }

    @NotNull
    default String getLang() {
        return "us";
    }

    @NotNull
    String getApiKey();

}
