package ru.blizzed.openlastfm.model;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class SkipRootObjectModelParser<ContentType> extends SkipRootModelParser<ContentType> {

    protected Class<ContentType> contentTypeClass;

    public SkipRootObjectModelParser(String elementTagName, Class<ContentType> contentTypeClass) {
        super(elementTagName);
        this.contentTypeClass = contentTypeClass;
    }

    @Override
    protected ContentType parseRootless(JsonObject nextToRootElement) {
        if (!getElementTagName().equals(""))
            return parseObject(nextToRootElement.getAsJsonObject(getElementTagName()));
        return parseObject(nextToRootElement);
    }

    private ContentType parseObject(JsonObject jsonObject) {
        return new Gson().fromJson(jsonObject, contentTypeClass);
    }

}
