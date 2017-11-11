package ru.blizzed.openlastfm.model.commons;

public class Tag {

    private String name;
    private String url;

    public Tag(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

}
