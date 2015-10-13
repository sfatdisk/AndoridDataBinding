package com.bawanj.andoriddatabinding.model;

import com.google.gson.annotations.SerializedName;

// you can make Movie extends Observable
public class Movie { // in the JSONArray

    @SerializedName("urlPoster") // GSON, it comes with Retrofit by default
    private String poster;

    @SerializedName("title")
    private String title;

    @SerializedName("year")
    private String year;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
