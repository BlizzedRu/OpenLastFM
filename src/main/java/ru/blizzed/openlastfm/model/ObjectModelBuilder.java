package ru.blizzed.openlastfm.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ObjectModelBuilder<ContentType> extends ModelBuilder<ContentType> {

    protected Class<ContentType> contentTypeClass;

    public ObjectModelBuilder(String elementTagName, Class<ContentType> contentTypeClass) {
        super(elementTagName);
        this.contentTypeClass = contentTypeClass;
    }

    @Override
    protected ContentType parse(JsonObject nextToRootElement) {
        if (!getElementTagName().equals(""))
            return parseObject(nextToRootElement.getAsJsonObject(getElementTagName()));
        return parseObject(nextToRootElement);
    }

    private ContentType parseObject(JsonObject jsonObject) {
        System.out.println(jsonObject.toString());
        return new Gson().fromJson(jsonObject, contentTypeClass);
    }

}
