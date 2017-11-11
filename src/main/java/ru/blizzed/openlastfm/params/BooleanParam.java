package ru.blizzed.openlastfm.params;

public class BooleanParam extends Param<Boolean> {

    public BooleanParam(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return data ? "1" : "0";
    }

}
