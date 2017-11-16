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
