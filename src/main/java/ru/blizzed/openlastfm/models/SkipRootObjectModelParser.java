package ru.blizzed.openlastfm.models;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class SkipRootObjectModelParser<ModelType> extends SkipRootModelParser<ModelType> {

    protected Class<ModelType> contentTypeClass;

    public SkipRootObjectModelParser(String elementTagName, Class<ModelType> contentTypeClass) {
        super(elementTagName);
        this.contentTypeClass = contentTypeClass;
    }

    @Override
    protected ModelType parseRootless(JsonObject nextToRootElement) {
        if (!getElementTagName().equals(""))
            return parseObject(nextToRootElement.getAsJsonObject(getElementTagName()));
        return parseObject(nextToRootElement);
    }

    private ModelType parseObject(JsonObject jsonObject) {
        return new Gson().fromJson(jsonObject, contentTypeClass);
    }

}
