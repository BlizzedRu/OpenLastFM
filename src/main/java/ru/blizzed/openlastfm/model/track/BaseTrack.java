package ru.blizzed.openlastfm.model.track;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.model.artist.BaseArtist;

import java.lang.reflect.Type;

public class BaseTrack {

    private String name;
    private String url;
    private int duration;
    private BaseArtist artist;

    @SerializedName("@attr")
    @JsonAdapter(RankDeserializer.class)
    private int rank;

    BaseTrack() {
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getDuration() {
        return duration;
    }

    public BaseArtist getArtist() {
        return artist;
    }

    public int getRank() {
        return rank;
    }

    private class RankDeserializer implements JsonDeserializer<Integer> {
        @Override
        public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return json.getAsJsonObject().getAsJsonPrimitive("rank").getAsInt();
        }
    }
}
