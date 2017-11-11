package ru.blizzed.openlastfm;

import com.sun.istack.internal.NotNull;

public final class OpenLastFMContext {

    private static final String ROOT_URL = "http://ws.audioscrobbler.com/";

    private static OpenLastFMContext instance;

    private OpenLastFMContextInitializer initializer;

    private OpenLastFMContext() {
    }

    public static void initialize(@NotNull String apiKey) {
        if (!isInitialized()) instance = new OpenLastFMContext();
        instance.initializer = () -> apiKey;
    }

    public static void initialize(@NotNull String apiKey, @NotNull String lang) {
        if (!isInitialized()) instance = new OpenLastFMContext();
        instance.initializer = new OpenLastFMContextInitializer() {
            @Override
            public String getApiKey() {
                return apiKey;
            }

            @Override
            public String getLang() {
                return lang;
            }
        };
    }

    public static void initialize(@NotNull OpenLastFMContextInitializer customContextInitializer) {
        if (!isInitialized()) instance = new OpenLastFMContext();
        instance.initializer = customContextInitializer;
    }

    public static boolean isInitialized() {
        return instance != null;
    }

    public static String getApiKey() {
        checkInit();
        return instance.initializer.getApiKey();
    }

    public static String getLang() {
        checkInit();
        return instance.initializer.getLang();
    }

    public static String getVersion() {
        checkInit();
        return instance.initializer.getVersion();
    }

    public static String getRootUrl() {
        checkInit();
        return ROOT_URL + getVersion() + "/" + "?format=json";
    }

    private static void checkInit() {
        if (!isInitialized()) throw new RuntimeException("OpenLastFMContext must be initialized first.");
    }

}
