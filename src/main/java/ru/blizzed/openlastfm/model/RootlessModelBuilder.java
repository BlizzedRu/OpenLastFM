package ru.blizzed.openlastfm.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class RootlessModelBuilder<ContentType> extends ObjectModelBuilder<ContentType> {

    public RootlessModelBuilder(String elementTagName, Class<ContentType> contentTypeClass) {
        super(elementTagName, contentTypeClass);
    }

    @Override
    public ContentType build(JsonObject root) {
        return parse(root);
    }

    protected ContentType parse(JsonObject root) {
        return parseObject(root);
    }

    private ContentType parseObject(JsonElement jsonElement) {
        return new Gson().fromJson(jsonElement, contentTypeClass);
    }

}
