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

package ru.blizzed.openlastfm.models;

import com.google.gson.JsonObject;

/**
 * An abstract parser for model with type of ModelType
 *
 * @param <ModelType> a model type
 *
 * @author BlizzedRu
 */
public abstract class ModelParser<ModelType> {

    private String elementTagName;

    /**
     * @param elementTagName name of the root element tag
     */
    public ModelParser(String elementTagName) {
        this.elementTagName = elementTagName;
    }

    public String getElementTagName() {
        return elementTagName;
    }

    /**
     * Returns a parsed model with type of ModelType
     *
     * @param root root element
     * @return parsed model
     */
    public abstract ModelType parse(JsonObject root);

}
