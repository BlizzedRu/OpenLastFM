package ru.blizzed.openlastfm.params;

public enum Period {

    WEEK("7day"),
    MONTH("1month"),
    THREE_MONTHS("3month"),
    SIX_MONTHS("6month"),
    TWELVE_MONTHS("12month"),
    OVERALL("overall");

    private String name;

    Period(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
