package ru.blizzed.openlastfm.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class PaginatedResultModelParser<PaginatedType extends PaginatedResult> extends SkipRootModelParser<PaginatedType> {

    private TypeToken<PaginatedType> typeToken;

    public PaginatedResultModelParser(TypeToken<PaginatedType> typeToken) {
        super("");
        this.typeToken = typeToken;
    }

    @Override
    protected PaginatedType parseRootless(JsonObject nextToRootElement) {
        return new Gson().fromJson(nextToRootElement, typeToken.getType());
    }

}
