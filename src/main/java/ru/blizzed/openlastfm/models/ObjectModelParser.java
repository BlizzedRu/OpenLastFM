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
import com.google.gson.JsonObject;

/**
 * Implementation of {@link ModelParser} for simple object
 *
 * @param <ModelType> type of expected model
 * @author BlizzedRu
 */
public class ObjectModelParser<ModelType> extends ModelParser<ModelType> {

    protected Class<ModelType> contentTypeClass;

    public ObjectModelParser(String elementTagName, Class<ModelType> contentTypeClass) {
        super(elementTagName);
        this.contentTypeClass = contentTypeClass;
    }

    @Override
    public ModelType parse(JsonObject root) {
        return parseObject(root);
    }

    private ModelType parseObject(JsonObject jsonObject) {
        return new Gson().fromJson(jsonObject, contentTypeClass);
    }

}
