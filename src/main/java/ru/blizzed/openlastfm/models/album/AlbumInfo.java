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

package ru.blizzed.openlastfm.models.album;

import ru.blizzed.openlastfm.models.commons.ArrayContainer;
import ru.blizzed.openlastfm.models.track.Track;

import java.util.List;

public class AlbumInfo extends Album {

    private ArrayContainer<Track> tracks;
    private Wiki wiki;
    private String artist;

    public String getArtist() {
        return artist;
    }

    public Wiki getWiki() {
        return wiki;
    }

    public List<Track> getTracks() {
        return tracks.getData();
    }

    public boolean hasTracks() {
        return tracks != null && !tracks.getData().isEmpty();
    }

    public static class Wiki {
        private String published;
        private String summary;
        private String content;

        Wiki() {
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
    }

}
