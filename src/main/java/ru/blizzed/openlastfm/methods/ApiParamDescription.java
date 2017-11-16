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

package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.Param;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Class represents a description for single {@link Param}
 * <p>It is used for describe a {@link Param}:
 * is it required and if yes – which {@link Param} <tt>(or params)</tt> can replace it
 * <p>
 * E.g. there are two required params <i>artist</i> and <i>album</i> in method <tt>album.getInfo</tt>,
 * but it can be replaced by param <i>mbid</i>
 * <p>In this case each of two required params has replacement – param <i>mbid</i>
 *
 * @author BlizzedRu
 */
public final class ApiParamDescription {

    private Param param;
    private boolean isRequired;
    private List<Param> replacements;

    public ApiParamDescription(Param param, boolean isRequired) {
        this.param = param;
        this.isRequired = isRequired;
    }

    public ApiParamDescription(Param param, boolean isRequired, Param... replacements) {
        this.param = param;
        this.isRequired = isRequired;
        this.replacements = Arrays.asList(replacements);
    }

    public Param getParam() {
        return param;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public boolean hasReplacements() {
        return replacements != null;
    }

    /**
     * Returns a {@link List} of replacements
     *
     * @return {@link List} of replacements or empty list if absent
     */
    public List<Param> getReplacements() {
        if (replacements == null) return Collections.emptyList();
        return replacements;
    }

}
