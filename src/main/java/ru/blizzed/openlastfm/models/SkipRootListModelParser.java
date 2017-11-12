package ru.blizzed.openlastfm.models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.Collections;
import java.util.List;

public class SkipRootListModelParser<ContentType> extends SkipRootModelParser<List<ContentType>> {

    private TypeToken<List<ContentType>> typeToken;

    public SkipRootListModelParser(String elementTagName, TypeToken<List<ContentType>> typeToken) {
        super(elementTagName);
        this.typeToken = typeToken;
    }

    @Override
    protected List<ContentType> parseRootless(JsonObject nextToRootElement) {
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
    private List<ContentType> parseList(JsonArray jsonArray) {
        return new Gson().fromJson(jsonArray, typeToken.getType());
    }

}
