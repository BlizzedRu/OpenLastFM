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

public class Tag {

    protected static final int DEF_VALUE = -1;

    private String name;
    private String url;
    private int count = DEF_VALUE;
    private Wiki wiki;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getCount() {
        return count;
    }

    public Wiki getWiki() {
        return wiki;
    }

    public boolean hasWiki() {
        return wiki != null;
    }

    public static class Wiki {

        private String summary;
        private String content;

        public String getSummary() {
            return summary;
        }

        public String getContent() {
            return content;
        }
    }

}
