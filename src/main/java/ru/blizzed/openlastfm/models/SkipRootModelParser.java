package ru.blizzed.openlastfm.models;

import com.google.gson.JsonObject;

public abstract class SkipRootModelParser<ModelType> extends ModelParser<ModelType> {

    public SkipRootModelParser(String elementTagName) {
        super(elementTagName);
    }

    @Override
    public ModelType parse(JsonObject root) {
        return parseRootless(removeRoot(root));
    }

    protected abstract ModelType parseRootless(JsonObject nextToRootElement);

    private JsonObject removeRoot(JsonObject root) {
        return root.get(root.keySet().iterator().next()).getAsJsonObject();
    }

}
