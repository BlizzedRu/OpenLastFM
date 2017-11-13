package ru.blizzed.openlastfm.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class SearchResultModelParser<ContentType extends BaseModel> extends SkipRootModelParser<SearchResult<ContentType>> {

    private TypeToken<SearchResult<ContentType>> typeToken;

    public SearchResultModelParser(TypeToken<SearchResult<ContentType>> typeToken) {
        super("");
        this.typeToken = typeToken;
    }

    @Override
    protected SearchResult<ContentType> parseRootless(JsonObject nextToRootElement) {
        return new Gson().fromJson(nextToRootElement, typeToken.getType());
    }

}
