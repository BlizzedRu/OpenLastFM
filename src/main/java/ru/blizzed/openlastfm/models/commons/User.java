/*
 * Copyright (c) 2017 BlizzedRu (Ivan Vlasov)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.blizzed.openlastfm.models.commons;

import com.google.gson.annotations.SerializedName;

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
