package ru.blizzed.openlastfm.model;

import com.google.gson.JsonObject;

public abstract class ModelBuilder<ContentType> {

    private String elementTagName;

    public String getElementTagName() {
        return elementTagName;
    }

    public ModelBuilder(String elementTagName) {
        this.elementTagName = elementTagName;
    }

    public ContentType build(JsonObject root) {
        return parse(removeRoot(root));
    }

    protected abstract ContentType parse(JsonObject nextToRootElement);

    private JsonObject removeRoot(JsonObject root) {
        return root.get(root.keySet().iterator().next()).getAsJsonObject();
    }

}
