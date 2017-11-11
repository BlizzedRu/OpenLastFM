package ru.blizzed.openlastfm.params;

public class MBIDParam extends Param<String> {

    private static final String MBID_PATTERN = "^[0-9a-f]{8}\\-[0-9a-f]{4}\\-[0-9a-f]{4}\\-[0-9a-f]{4}\\-[0-9a-f]{12}$";

    public MBIDParam(String name) {
        super(name);
    }

    @Override
    public Param<String> of(String data) {
        if (data != null && data.matches(MBID_PATTERN)) return super.of(data);
        else throw new IllegalArgumentException("Param doesn't match MBID pattern.");
    }
}
