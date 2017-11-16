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

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PageResult<ModelType> implements PaginatedResult<PageResult<ModelType>> {

    @SerializedName(value = "track", alternate = {"album", "tag", "artist"})
    private List<ModelType> items;

    @SerializedName("@attr")
    private Attrs attrs;

    public List<ModelType> getItems() {
        return items;
    }

    public int getPerPage() {
        return attrs.perPage;
    }

    public int getTotalItems() {
        return attrs.total;
    }

    public int getRealItemsCount() {
        return items.size();
    }

    @Override
    public int getTotalPages() {
        return attrs.totalPages;
    }

    @Override
    public int getCurrentPage() {
        return attrs.page;
    }

    private static class Attrs {
        private int page;
        private int perPage;
        private int totalPages;
        private int total;
    }

}
