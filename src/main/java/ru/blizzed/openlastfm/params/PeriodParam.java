package ru.blizzed.openlastfm.params;

public class PeriodParam extends Param<Period> {

    public PeriodParam(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return data.getName();
    }

}
