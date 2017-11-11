package ru.blizzed.openlastfm.model;

import com.google.gson.JsonObject;

public abstract class SkipRootModelParser<ContentType> extends ModelParser<ContentType> {

    public SkipRootModelParser(String elementTagName) {
        super(elementTagName);
    }

    @Override
    public ContentType parse(JsonObject root) {
        return parseRootless(removeRoot(root));
    }

    protected abstract ContentType parseRootless(JsonObject nextToRootElement);

    private JsonObject removeRoot(JsonObject root) {
        return root.get(root.keySet().iterator().next()).getAsJsonObject();
    }

}
