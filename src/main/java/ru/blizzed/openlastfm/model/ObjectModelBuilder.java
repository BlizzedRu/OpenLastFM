package ru.blizzed.openlastfm.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ObjectModelBuilder<ContentType> extends ModelBuilder<ContentType> {

    protected Class<ContentType> contentTypeClass;

    public ObjectModelBuilder(String elementTagName, Class<ContentType> contentTypeClass) {
        super(elementTagName);
        this.contentTypeClass = contentTypeClass;
    }

    @Override
    protected ContentType parse(JsonObject nextToRootElement) {
        if (!getElementTagName().equals("")) parseObject(nextToRootElement.getAsJsonObject(getElementTagName()));
        return parseObject(nextToRootElement);
    }

    private ContentType parseObject(JsonElement jsonElement) {
        return new Gson().fromJson(jsonElement, contentTypeClass);
    }

}
