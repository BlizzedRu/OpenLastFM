package ru.blizzed.openlastfm.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ObjectModelParser<ContentType> extends ModelParser<ContentType> {

    protected Class<ContentType> contentTypeClass;

    public ObjectModelParser(String elementTagName, Class<ContentType> contentTypeClass) {
        super(elementTagName);
        this.contentTypeClass = contentTypeClass;
    }

    @Override
    public ContentType parse(JsonObject root) {
        return parseObject(root);
    }

    private ContentType parseObject(JsonObject jsonObject) {
        return new Gson().fromJson(jsonObject, contentTypeClass);
    }

}
