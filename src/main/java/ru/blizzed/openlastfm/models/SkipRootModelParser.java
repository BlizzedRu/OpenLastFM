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
 * An abstract implementation of {@link ModelParser} that skips a root element
 *
 * @param <ModelType> type of expected model
 *
 * @author BlizzedRu
 */
public abstract class SkipRootModelParser<ModelType> extends ModelParser<ModelType> {

    public SkipRootModelParser(String elementTagName) {
        super(elementTagName);
    }

    @Override
    public ModelType parse(JsonObject root) {
        return parseRootless(removeRoot(root));
    }

    protected abstract ModelType parseRootless(JsonObject nextToRootElement);

    private JsonObject removeRoot(JsonObject root) {
        return root.get(root.keySet().iterator().next()).getAsJsonObject();
    }

}
