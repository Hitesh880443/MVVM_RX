package com.hitesh.mvvmrx.model;

public class AndroidVersion {

    String api_level;
    String name;
    String release_date;
    String version;

    public AndroidVersion() {
    }

    public String getApi_level() {
        return api_level;
    }

    public void setApi_level(String api_level) {
        this.api_level = api_level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
