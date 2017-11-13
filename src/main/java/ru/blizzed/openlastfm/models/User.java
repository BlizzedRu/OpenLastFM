package ru.blizzed.openlastfm.models;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.openlastfm.models.commons.Image;

import java.util.Date;

public class User {

    private String bootstrap;

    private String scrobblesource;

    private Date registered;

    private String age;

    private String name;

    private String gender;

    @SerializedName("image")
    private Image image;

    private String playcount;

    private String playlists;

    private String realname;

    private String type;

    private String subscriber;

    private String url;

    private String country;

    public String getBootstrap() {
        return bootstrap;
    }

    public String getScrobbleSource() {
        return scrobblesource;
    }

    public Date getRegisteredDate() {
        return registered;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPlaycount() {
        return playcount;
    }

    public String getPlaylists() {
        return playlists;
    }

    public String getRealname() {
        return realname;
    }

    public String getType() {
        return type;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public String getUrl() {
        return url;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "User [bootstrap = " + bootstrap + ", scrobblesource = " + scrobblesource + ", registered = " + registered + ", age = " + age + ", name = " + name + ", gender = " + gender + ", image = " + image + ", playcount = " + playcount + ", playlists = " + playlists + ", realname = " + realname + ", type = " + type + ", subscriber = " + subscriber + ", url = " + url + ", country = " + country + "]";
    }
}