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
