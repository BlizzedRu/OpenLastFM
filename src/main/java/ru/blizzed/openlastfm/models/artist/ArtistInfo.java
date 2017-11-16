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

import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.models.BaseModel;
import ru.blizzed.openlastfm.models.commons.ArrayContainer;
import ru.blizzed.openlastfm.models.commons.Link;

import java.util.Collections;
import java.util.List;

public class ArtistInfo extends BaseModel {

    @SerializedName("ontour")
    private String onTour;

    private Bio bio;
    private ArrayContainer<Artist> similar;

    public boolean isOnTour() {
        return "1".equals(onTour);
    }

    public Bio getBio() {
        return bio;
    }

    public List<Artist> getSimilar() {
        if (similar == null) return Collections.emptyList();
        return similar.getData();
    }

    public static class Bio {
        private String published;
        private String summary;
        private String content;
        private ArrayContainer<Link> links;

        private Bio() {
        }

        public String getPublished() {
            return published;
        }

        public String getSummary() {
            return summary;
        }

        public String getContent() {
            return content;
        }

        public List<Link> getLinks() {
            return links.getData();
        }
    }

}
