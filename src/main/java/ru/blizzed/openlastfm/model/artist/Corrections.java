package ru.blizzed.openlastfm.model.artist;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Corrections {

    private List<Correction> data;

    private Corrections() {
    }

    public List<Correction> getAll() {
        return data;
    }

    public static class Correction {

        private BaseArtist artist;
        private int index;

        private Correction() {
        }

        public BaseArtist getArtist() {
            return artist;
        }

        public int getIndex() {
            return index;
        }
    }

    public static class Deserializer implements JsonDeserializer<Corrections> {
        @Override
        public Corrections deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
            Corrections corrections = new Corrections();

            if (jsonElement.isJsonObject()) {
                corrections.data = new ArrayList<>(1);
                corrections.data.add(deserializeSingleCorrection(jsonElement.getAsJsonObject().getAsJsonObject("corrections").getAsJsonObject("correction")));
            } else if (jsonElement.isJsonArray()) {
                JsonArray correctionsJsonArray = jsonElement.getAsJsonArray();
                corrections.data = new ArrayList<>(correctionsJsonArray.size());
                for (JsonElement element : correctionsJsonArray) {
                    corrections.data.add(deserializeSingleCorrection(element.getAsJsonObject()));
                }

                corrections.data.sort(Comparator.comparingInt(Correction::getIndex));
            }

            return corrections;
        }

        private Correction deserializeSingleCorrection(JsonObject element) {
            Correction correction = new Correction();
            correction.index = element.getAsJsonObject("@attr").getAsJsonPrimitive("index").getAsInt();
            element = element.getAsJsonObject("artist");
            correction.artist = new BaseArtist(
                    element.getAsJsonPrimitive("name").getAsString(),
                    element.getAsJsonPrimitive("url").getAsString(),
                    element.getAsJsonPrimitive("mbid").getAsString()
            );
            return correction;
        }

    }

}
