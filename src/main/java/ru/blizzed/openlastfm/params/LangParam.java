package ru.blizzed.openlastfm.params;

import java.util.Locale;

public class LangParam extends Param<Locale> {

    public LangParam(String name) {
        super(name);
    }

    @Override
    public String toString() {
        if (data != null && data.getLanguage().length() != 0) {
            return data.getLanguage();
        } else throw new IllegalArgumentException("Locale is broken.");
    }

}
