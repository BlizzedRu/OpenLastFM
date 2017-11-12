package ru.blizzed.openlastfm.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.models.commons.ArrayContainer;
import ru.blizzed.openlastfm.models.commons.Image;
import ru.blizzed.openlastfm.models.tag.Tag;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

public class BaseModel {

    protected static final int DEF_VALUE = -1;

    @SerializedName(value = "name", alternate = {"#text"})
    private String name;
    private String mbid;
    private String url;

    @SerializedName("playcount")
    private long playCount = DEF_VALUE;
    private long listeners = DEF_VALUE;

    @SerializedName("streamable")
    @JsonAdapter(StreamableDeserializer.class)
    private Streamable streamableEntry;

    private Image image;

    @SerializedName(value = "tags", alternate = {"toptags"})
    private ArrayContainer<Tag> tags;

    public String getName() {
        return name;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public long getPlayCount() {
        return playCount;
    }

    public long getListeners() {
        return listeners;
    }

    public Image getImage() {
        return image;
    }

    public List<Tag> getTags() {
        return tags.getData();
    }

    public boolean isStreamable() {
        return streamableEntry != null && streamableEntry.getFulltrack();
    }

    public boolean hasName() {
        return name != null;
    }

    public boolean hasMbid() {
        return mbid != null;
    }

    public boolean hasUrl() {
        return url != null;
    }

    public boolean hasPlayCount() {
        return playCount != DEF_VALUE;
    }

    public boolean hasListeners() {
        return listeners != DEF_VALUE;
    }

    public boolean hasImage() {
        return image != null;
    }

    public boolean hasTags() {
        return tags != null && !tags.getData().isEmpty();
    }

    static class Streamable {
        private String fulltrack;

        boolean getFulltrack() {
            return "1".equals(fulltrack);
        }
    }

    static class StreamableDeserializer implements JsonDeserializer<Streamable> {
        @Override
        public Streamable deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Streamable streamable = new Streamable();
            if (json.isJsonPrimitive()) streamable.fulltrack = json.getAsString();
            else streamable.fulltrack = json.getAsJsonObject().getAsJsonPrimitive("fulltrack").getAsString();
            return streamable;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof BaseModel)) return false;
        BaseModel entry = (BaseModel) obj;
        if (hasMbid() & entry.hasMbid())
            return entry.getMbid().equals(getMbid());
        if (hasUrl() & entry.hasUrl())
            return entry.getUrl().equals(getUrl());
        return (hasName() & entry.hasName()) && entry.getName().equals(getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mbid, url, playCount, listeners, streamableEntry, image, tags);
    }
}
