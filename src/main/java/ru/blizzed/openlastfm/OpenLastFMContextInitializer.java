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

/**
 * Interface for initializing the {@link OpenLastFMContext}
 * <p>
 * <p>You can initialize the {@link OpenLastFMContext} with custom <i>version</i> or <i>lang</i> parameters
 *
 * @author BlizzedRu
 */
public interface OpenLastFMContextInitializer {

    /**
     * Use it at your own risk
     *
     * @return version
     */
    @NotNull
    default String getVersion() {
        return "2.0";
    }

    /**
     * Your language expressed as an <strong>ISO 639 alpha-2 code</strong> <i>(e.g. "ru", "de", etc)</i>
     *
     * @return lang
     */
    @NotNull
    default String getLang() {
        return "us";
    }

    @NotNull
    String getApiKey();

}
