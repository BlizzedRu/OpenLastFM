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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.Collections;
import java.util.List;

/**
 * An abstract implementation of {@link SkipRootModelParser} for a list of objects
 * <p>Skips a root
 *
 * @param <ModelType> type of expected list type
 *
 * @author BlizzedRu
 */
public class SkipRootListModelParser<ModelType> extends SkipRootModelParser<List<ModelType>> {

    private TypeToken<List<ModelType>> typeToken;

    public SkipRootListModelParser(String elementTagName, TypeToken<List<ModelType>> typeToken) {
        super(elementTagName);
        this.typeToken = typeToken;
    }

    @Override
    protected List<ModelType> parseRootless(JsonObject nextToRootElement) {
        if (!nextToRootElement.has(getElementTagName()))
            return Collections.emptyList();
        return parseList(nextToRootElement.getAsJsonArray(getElementTagName()));
    }

    /**
     * Uses TypeToken because Google's Gson can't get generic type at runtime
     *
     * @param jsonArray
     * @return parsed {@link List} of objects
     */
    private List<ModelType> parseList(JsonArray jsonArray) {
        return new Gson().fromJson(jsonArray, typeToken.getType());
    }

}
