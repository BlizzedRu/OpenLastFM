package ru.blizzed.openlastfm.models;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.models.commons.ArrayContainer;

import java.util.List;

public class SearchResult<ResultType extends BaseModel> {

    @SerializedName("opensearch:Query")
    private Query query;

    @SerializedName("opensearch:totalResults")
    private int totalResults;

    @SerializedName("opensearch:startIndex")
    private int startIndex;

    @SerializedName("opensearch:itemsPerPage")
    private int itemsPerPage;

    @SerializedName(value = "albummatches", alternate = {"artistmatches", "trackmatches"})
    private ArrayContainer<ResultType> items;

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

    public List<ResultType> getItems() {
        return items.getData();
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
