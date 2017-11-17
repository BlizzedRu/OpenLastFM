/*
 * Copyright (c) 2017 BlizzedRu (Ivan Vlasov)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.blizzed.openlastfm;

import com.sun.istack.internal.NotNull;

import java.util.Locale;

/**
 * This class is a start point of OpenLastFM usage
 * <p>You must call one of <strong>initialize</strong> methods to use this library
 * <p>There are many <i>initialize</i> versions for you, choose the appropriate one
 * <p>
 *
 * @author BlizzedRu
 * @see #initialize(String)
 * @see #initialize(String, Locale)
 * @see #initialize(OpenLastFMContextInitializer)
 */
public final class OpenLastFMContext {

    private static final String ROOT_URL = "http://ws.audioscrobbler.com/";

    private static OpenLastFMContext instance;

    private OpenLastFMContextInitializer initializer;

    private OpenLastFMContext() {
    }

    /**
     * The simplest way to initialize OpenLastFM
     * <p>
     * Use this one if you don't care about <i>lang</i> param <i>(default is <strong>US</strong>)</i>
     * <p>
     * If you need multilanguage you can use this one and pass a <i>lang</i> param in each method requires it
     *
     * @param apiKey your Last.FM API key
     */
    public static void initialize(@NotNull String apiKey) {
        if (!isInitialized()) instance = new OpenLastFMContext();
        instance.initializer = () -> apiKey;
    }

    /**
     * A simple way to initialize OpenLastFM
     * <p>
     * Use this one if you need a custom <i>(not <strong>US</strong>)</i> language
     * <p>
     * If you need multilanguage you can use {@link #initialize(String)} and pass a <i>lang</i> param in each method requires it
     * <p>Last.FM requires language expressed as an <strong>ISO 639 alpha-2 code</strong> <i>(e.g. "ru", "de", "fr", etc)</i>
     * so u can use simple {@link Locale} java class. E.g. {@link Locale#GERMAN} or <code>new Locale("ru")</code>
     *
     * @param apiKey     your Last.FM API key
     * @param langLocale your {@link Locale}
     */
    public static void initialize(@NotNull String apiKey, @NotNull Locale langLocale) {
        if (!isInitialized()) instance = new OpenLastFMContext();
        instance.initializer = new OpenLastFMContextInitializer() {
            @Override
            public String getApiKey() {
                return apiKey;
            }

            @Override
            public String getLang() {
                return langLocale.getLanguage();
            }
        };
    }

    /**
     * Not simple way to initialize OpenLastFM
     * <p>
     * I don't think you really need it, but.. But you can use {@link OpenLastFMContextInitializer}
     * to set your own version of LastFM API or play with getting <i>lang</i> or <i>apiKey</i> parameters at runtime
     *
     * @param customContextInitializer your custom {@link OpenLastFMContextInitializer}
     */
    public static void initialize(@NotNull OpenLastFMContextInitializer customContextInitializer) {
        if (!isInitialized()) instance = new OpenLastFMContext();
        instance.initializer = customContextInitializer;
    }

    /**
     * Checks if you (or someone else) initialized OpenLastFM
     *
     * @return true if OpenLastFF is initialized
     */
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

    /**
     * Returns a full URL to the Last.FM API service as {@link String}
     *
     * @return full URL to Last.FM API
     */
    public static String getRootUrl() {
        checkInit();
        return ROOT_URL + getVersion() + "/" + "?format=json";
    }

    private static void checkInit() {
        if (!isInitialized()) throw new RuntimeException("OpenLastFMContext must be initialized first.");
    }

}
