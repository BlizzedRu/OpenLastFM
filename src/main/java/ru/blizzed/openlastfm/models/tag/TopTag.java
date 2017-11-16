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

package ru.blizzed.openlastfm.models.tag;

public class TopTag extends Tag {

    private long reach = DEF_VALUE;
    private long taggings = DEF_VALUE;
    private String streamable;

    public long getReach() {
        return reach;
    }

    public long getTaggings() {
        return taggings;
    }

    public boolean isStreamable() {
        return "1".equals(streamable);
    }

    public boolean hasTaggings() {
        return taggings != DEF_VALUE;
    }

    public boolean hasReach() {
        return reach != DEF_VALUE;
    }

}
