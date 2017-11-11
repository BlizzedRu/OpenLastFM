package ru.blizzed.openlastfm.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.Collections;
import java.util.List;

public class ListModelBuilder<ContentType> extends ModelBuilder<List<ContentType>> {

    public ListModelBuilder(String elementTagName) {
        super(elementTagName);
    }

    @Override
    protected List<ContentType> parse(JsonObject root) {
        if (root.keySet().contains("#text")) return Collections.emptyList();
        if (!getElementTagName().equals("")) return parseList(root.getAsJsonArray(getElementTagName()));
        return parseList(root);
    }

    private List<ContentType> parseList(JsonElement jsonElement) {
        return new Gson().fromJson(jsonElement, new TypeToken<List<ContentType>>(){}.getType());
    }

}
