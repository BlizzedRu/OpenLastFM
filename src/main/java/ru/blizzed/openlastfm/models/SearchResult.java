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
import ru.blizzed.openlastfm.models.commons.ArrayContainer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Implementation of {@link PaginatedResult} for search result
 *
 * @param <ModelType> type of expected items on search page
 * @author BlizzedRu
 */
public class SearchResult<ModelType extends BaseModel> implements PaginatedResult<SearchResult<ModelType>> {

    @SerializedName("opensearch:Query")
    private Query query;

    @SerializedName("opensearch:totalResults")
    private int totalResults;

    @SerializedName("opensearch:startIndex")
    private int startIndex;

    @SerializedName("opensearch:itemsPerPage")
    private int itemsPerPage;

    @SerializedName(value = "albummatches", alternate = {"artistmatches", "trackmatches"})
    private ArrayContainer<ModelType> items;

    public Query getQuery() {
        return query;
    }

    /**
     * Returns total amount of found items
     *
     * @return total amount of items
     */
    public int getTotalResults() {
        return totalResults;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public List<ModelType> getItems() {
        return items.getData();
    }

    /**
     * Returns amount of loaded items
     *
     * @return amount of loaded items
     */
    public int getRealItemsCount() {
        return getItems().size();
    }

    @Override
    public int getTotalPages() {
        return new BigDecimal(getTotalResults() / getItemsPerPage()).setScale(0, RoundingMode.UP).intValue();
    }

    @Override
    public int getCurrentPage() {
        return query.startPage;
    }

    public static class Query {
        @SerializedName("#text")
        private String text;
        private String role;
        private String searchTerms;
        private int startPage;

        public String getText() {
            return text;
        }

        public String getRole() {
            return role;
        }

        public String getSearchTerms() {
            return searchTerms;
        }

        public int getStartPage() {
            return startPage;
        }
    }

}
