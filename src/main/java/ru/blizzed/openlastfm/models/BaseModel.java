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

/**
 * This class is a base model that provides common fields and methods of frequently used API objects
 * e.g. {@link ru.blizzed.openlastfm.models.artist.Artist}, {@link ru.blizzed.openlastfm.models.track.Track}, {@link ru.blizzed.openlastfm.models.album.Album}
 * <p>
 * May be deserialized from any standard JSON representation, even takes into account the peculiarity
 * of different <tt>streamable</tt> representations (as Object, as String).
 *
 * @see ru.blizzed.openlastfm.models.artist.Artist
 * @see ru.blizzed.openlastfm.models.track.Track
 * @see ru.blizzed.openlastfm.models.album.Album
 */
public class BaseModel {

    /**
     * Default value of int field if absent
     */
    protected static final int DEF_VALUE = -1;

    /**
     * Some objects have <i>#text</i> name of <tt>name</tt> field
     * E.g. <tt>user.ArtistTracks</tt>, <tt>user.RecentTracks</tt> and etc
     */
    @SerializedName(value = "name", alternate = {"#text"})
    private String name;

    private String mbid;
    private String url;

    @SerializedName("playcount")
    private long playCount = DEF_VALUE;
    private long listeners = DEF_VALUE;

    /**
     * @see Streamable
     */
    @SerializedName("streamable")
    @JsonAdapter(StreamableDeserializer.class)
    private Streamable streamableEntry;

    private Image image;

    /**
     * Some objects have <i>toptags</i> name of <tt>tags</tt> field
     *
     * @see ArrayContainer
     */
    @SerializedName(value = "tags", alternate = {"toptags"})
    private ArrayContainer<Tag> tags;

    /**
     * Returns name of the entry or <strong>null</strong> if absent
     *
     * @return <i>name</i> tag content
     */
    public String getName() {
        return name;
    }

    /**
     * Returns mbid of the entry or <strong>null</strong> if absent
     *
     * @return <i>mbid</i> tag content
     */
    public String getMbid() {
        return mbid;
    }

    /**
     * Returns url of the entry or <strong>null</strong> if absent
     *
     * @return <i>url</i> tag content
     */
    public String getUrl() {
        return url;
    }

    /**
     * Returns playcount of the entry or <strong>{@link #DEF_VALUE}</strong> if absent
     *
     * @return <i>playcount</i> tag content
     */
    public long getPlayCount() {
        return playCount;
    }

    /**
     * Returns listeners of the entry or <strong>{@link #DEF_VALUE}</strong> if absent
     *
     * @return <i>listeners</i> tag content
     */
    public long getListeners() {
        return listeners;
    }

    /**
     * Returns image of the entry or <strong>null</strong> if absent
     *
     * @return <i>image</i> tag content
     * @see Image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Returns tags of the entry or <strong>null</strong> if absent
     *
     * @return <i>tags</i> or <i>toptags</i> tag content
     */
    public List<Tag> getTags() {
        return tags.getData();
    }

    /**
     * Returns streamable of the entry, <strong>false</strong> if absent
     *
     * @return <i>streamable</i> tag content
     */
    public boolean isStreamable() {
        return streamableEntry != null && streamableEntry.getFulltrack();
    }

    /**
     * Checks the entry for <i>name</i> tag existence
     *
     * @return <strong>true</strong> if <i>name</i> tag exists
     */
    public boolean hasName() {
        return name != null;
    }

    /**
     * Checks the entry for <i>mbid</i> tag existence
     *
     * @return <strong>true</strong> if <i>mbid</i> tag exists
     */
    public boolean hasMbid() {
        return mbid != null;
    }

    /**
     * Checks the entry for <i>url</i> tag existence
     *
     * @return <strong>true</strong> if <i>url</i> tag exists
     */
    public boolean hasUrl() {
        return url != null;
    }

    /**
     * Checks the entry for <i>playcount</i> tag existence
     *
     * @return <strong>true</strong> if <i>playcount</i> tag exists
     */
    public boolean hasPlayCount() {
        return playCount != DEF_VALUE;
    }

    /**
     * Checks the entry for <i>listeners</i> tag existence
     *
     * @return <strong>true</strong> if <i>listeners</i> tag exists
     */
    public boolean hasListeners() {
        return listeners != DEF_VALUE;
    }

    /**
     * Checks the entry for <i>image</i> tag existence
     *
     * @return <strong>true</strong> if <i>image</i> tag exists
     */
    public boolean hasImage() {
        return image != null;
    }

    /**
     * Checks the entry for <i>tags</i> or <i>toptags</i> tag existence
     *
     * @return <strong>true</strong> if <i>tags</i> or <i>toptags</i> tag exists
     */
    public boolean hasTags() {
        return tags != null && !tags.getData().isEmpty();
    }

    /**
     * Bean inner class for <i>streamable</i> tag representation
     * <p>Replaces a string content of <i>streamable</i> or takes a <i>fulltrack</i>
     * tag value if <i>streamable</i> is an object e.g. in <tt>artist.getSimilar</tt>
     */
    static class Streamable {
        private String fulltrack;

        boolean getFulltrack() {
            return "1".equals(fulltrack);
        }
    }

    /**
     * Custom Gson deserializer for <i>streamable</i> tag
     * @see Streamable
     */
    static class StreamableDeserializer implements JsonDeserializer<Streamable> {
        @Override
        public Streamable deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Streamable streamable = new Streamable();
            if (json.isJsonPrimitive()) streamable.fulltrack = json.getAsString();
            else streamable.fulltrack = json.getAsJsonObject().getAsJsonPrimitive("fulltrack").getAsString();
            return streamable;
        }
    }

    /**
     * Compares this {@link BaseModel} with another {@link Object}
     * <p>Returns <strong>true</strong> only if <tt>obj</tt> is instance of {@link BaseModel} and
     * has the same {@link #mbid} or {@link #url} or {@link #name}
     * @param obj another object
     * @return result of comparison
     */
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
