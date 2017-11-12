package ru.blizzed.openlastfm.models.commons;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.JsonAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@JsonAdapter(ArrayContainer.Deserializer.class)
public class ArrayContainer<E> {

    private List<E> data;

    private ArrayContainer() {
    }

    public List<E> getData() {
        return data;
    }

    protected class Deserializer implements JsonDeserializer<ArrayContainer<E>> {

        @Override
        public ArrayContainer<E> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
            ArrayContainer<E> arrayContainer = new ArrayContainer<>();
            arrayContainer.data = new ArrayList<>();

            String key = jsonElement.getAsJsonObject().keySet().iterator().next();
            JsonElement element = jsonElement.getAsJsonObject().get(key);
            try {
                Class clazz = getGenericClass(type);
                if (element.isJsonArray()) {
                    for (JsonElement elem : element.getAsJsonArray()) {
                        arrayContainer.data.add(context.deserialize(elem, clazz));
                    }
                } else {
                    arrayContainer.data.add(context.deserialize(element, clazz));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return arrayContainer;
        }

        private Class getGenericClass(Type type) throws ClassNotFoundException {
            String name = type.getTypeName();
            String cut = name.replaceAll("\\<\\S*\\>", "");
            name = name.replaceAll(cut, "");
            name = name.replaceAll("<", "").replaceAll(">", "");
            return Class.forName(name);
        }
    }

}
