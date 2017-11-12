package ru.blizzed.openlastfm.models;

public class Error {

    public static final String JSON_KEY = "error";

    private int error;
    private String message;

    private Error(){
    }

    public Error(int error, String message) {
        this.error = error;
        this.message = message;
    }

    public int getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

}
