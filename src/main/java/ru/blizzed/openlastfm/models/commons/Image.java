package ru.blizzed.openlastfm.models.commons;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

@JsonAdapter(Image.ImageDeserializer.class)
public class Image {

    private List<ImageEntry> images;

    public enum Size {
        @SerializedName("small")
        SMALL,

        @SerializedName("medium")
        MEDIUM,

        @SerializedName("large")
        LARGE,

        @SerializedName("extralarge")
        EXTRALARGE,

        @SerializedName("mega")
        MEGA,

        @SerializedName("")
        DEFAULT
    }

    public String getUrl(Size size) {
        return images.stream()
                .filter(i -> i.size.equals(size))
                .findFirst()
                .orElse(new ImageEntry())
                .url;
    }

    private static class ImageEntry {
        @SerializedName("#text")
        private String url;

        @SerializedName("size")
        private Size size;
    }

    static class ImageDeserializer implements JsonDeserializer<Image> {
        @Override
        public Image deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Image image = new Image();
            image.images = context.deserialize(json, new TypeToken<List<ImageEntry>>() {
            }.getType());
            return image;
        }
    }


}
