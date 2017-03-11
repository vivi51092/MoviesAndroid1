package com.curso.moviesandroid.Models;

/**
 * Created by 210206561 on 11/03/2017.
 */

public class Movie {
    private int id;
    private String title;
    private String descrpction;
    private String poster_path;


    public Movie(int id, String title, String descrpction, String poster_path) {
        this.id = id;
        this.title = title;
        this.descrpction = descrpction;
        this.poster_path = poster_path;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrpction() {
        return descrpction;
    }

    public void setDescrpction(String descrpction) {
        this.descrpction = descrpction;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
