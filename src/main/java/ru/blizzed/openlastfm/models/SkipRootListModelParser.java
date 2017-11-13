package ru.blizzed.openlastfm.models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.Collections;
import java.util.List;

public class SkipRootListModelParser<ModelType> extends SkipRootModelParser<List<ModelType>> {

    private TypeToken<List<ModelType>> typeToken;

    public SkipRootListModelParser(String elementTagName, TypeToken<List<ModelType>> typeToken) {
        super(elementTagName);
        this.typeToken = typeToken;
    }

    @Override
    protected List<ModelType> parseRootless(JsonObject nextToRootElement) {
        if (!nextToRootElement.has(getElementTagName()))
            return Collections.emptyList();
        return parseList(nextToRootElement.getAsJsonArray(getElementTagName()));
    }

    /**
     * Uses TypeToken because Google's Gson can't get generic type at runtime
     *
     * @param jsonArray
     * @return
     */
    private List<ModelType> parseList(JsonArray jsonArray) {
        return new Gson().fromJson(jsonArray, typeToken.getType());
    }

}
