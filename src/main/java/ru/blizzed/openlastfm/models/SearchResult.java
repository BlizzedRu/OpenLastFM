package ru.blizzed.openlastfm.models;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.methods.ApiParams;
import ru.blizzed.openlastfm.methods.ApiRequest;
import ru.blizzed.openlastfm.models.commons.ArrayContainer;
import ru.blizzed.openlastfm.params.LastFMParams;
import ru.blizzed.openlastfm.params.Param;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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

    public int getRealItemsCount() {
        return getItems().size();
    }

    public int getPagesCount() {
        return new BigDecimal(getTotalResults() / getItemsPerPage()).setScale(0, RoundingMode.UP).intValue();
    }

    public boolean hasNextPage() {
        return getStartIndex() + getItemsPerPage() < getTotalResults();
    }

    public int getCurrentPage() {
        return query.startPage;
    }

    @SuppressWarnings("unchecked")
    public ApiRequest<SearchResult<ResultType>> getNextPageRequest(ApiRequest<SearchResult<ResultType>> prevRequest) {
        List<Param> params = new ArrayList<>(prevRequest.getParams().asList());
        if (params.contains(LastFMParams.PAGE))
            params.remove(LastFMParams.PAGE);
        params.add(LastFMParams.PAGE.of(getCurrentPage() + 1));
        return new ApiRequest<>(prevRequest.getMethod(), ApiParams.from(params));
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
