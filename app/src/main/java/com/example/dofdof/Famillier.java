package com.example.dofdof;

public class Famillier {
    private int _id;
    private String name;
    private String imgUrl;
    private String Url;
    private String description;
    private String MaxStats;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxStats() {
        return MaxStats;
    }

    public void setMaxStats(String maxStats) {
        MaxStats = maxStats;
    }
}

