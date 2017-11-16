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

package ru.blizzed.openlastfm.models.artist;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import ru.blizzed.openlastfm.models.BaseModel;

import java.lang.reflect.Type;

public class Artist extends BaseModel {

    @JsonAdapter(StatsDeserializer.class)
    private StatsEntry stats;

    @Override
    public long getListeners() {
        return stats == null ? super.getListeners() : stats.listeners;
    }

    @Override
    public long getPlayCount() {
        return stats == null ? super.getPlayCount() : stats.playcount;
    }

    @Override
    public boolean hasPlayCount() {
        return stats != null || super.hasPlayCount();
    }

    @Override
    public boolean hasListeners() {
        return stats != null || super.hasListeners();
    }

    private static class StatsEntry {
        private long listeners;
        private long playcount;
    }

    static class StatsDeserializer implements JsonDeserializer<StatsEntry> {
        @Override
        public StatsEntry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject root = json.getAsJsonObject();
            StatsEntry stats = new StatsEntry();
            stats.listeners = root.getAsJsonPrimitive("listeners").getAsInt();
            stats.playcount = root.getAsJsonPrimitive("playcount").getAsInt();
            return stats;
        }
    }

}
