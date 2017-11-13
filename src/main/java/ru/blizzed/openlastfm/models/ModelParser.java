package ru.blizzed.openlastfm.models;

import com.google.gson.JsonObject;

public abstract class ModelParser<ModelType> {

    private String elementTagName;

    public ModelParser(String elementTagName) {
        this.elementTagName = elementTagName;
    }

    public String getElementTagName() {
        return elementTagName;
    }

    public abstract ModelType parse(JsonObject root);

}
