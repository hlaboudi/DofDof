package com.example.dofdof.Model;

import java.util.ArrayList;

public class Pets {
    private int _id;
    private String name;
    private String imgUrl;
    private String url;
    private String description;
    private ArrayList<String> maxstats;
    private int lvl;

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
        return url;
    }

    public void setUrl(String url) {
        url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getMaxStats() {
        return maxstats;
    }

    public void setMaxStats(ArrayList<String> maxStats) {
        maxStats = maxStats;
    }

    public Integer getLevel() {
        return lvl;
    }
}

