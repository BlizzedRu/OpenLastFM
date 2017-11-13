package ru.blizzed.openlastfm.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ObjectModelParser<ModelType> extends ModelParser<ModelType> {

    protected Class<ModelType> contentTypeClass;

    public ObjectModelParser(String elementTagName, Class<ModelType> contentTypeClass) {
        super(elementTagName);
        this.contentTypeClass = contentTypeClass;
    }

    @Override
    public ModelType parse(JsonObject root) {
        return parseObject(root);
    }

    private ModelType parseObject(JsonObject jsonObject) {
        return new Gson().fromJson(jsonObject, contentTypeClass);
    }

}
