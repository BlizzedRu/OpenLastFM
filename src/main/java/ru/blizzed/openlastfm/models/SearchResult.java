package ru.blizzed.openlastfm.models;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.models.commons.ArrayContainer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

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
