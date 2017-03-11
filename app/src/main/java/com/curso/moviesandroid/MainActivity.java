package com.curso.moviesandroid;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.curso.moviesandroid.Models.Movie;
import com.curso.moviesandroid.com.curso.moviesandroid.network.NtworkConexion;
import com.curso.moviesandroid.jsnon_utilities.JsonParse;
import com.curso.moviesandroid.listener.NetworkConecctionInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NetworkConecctionInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NtworkConexion connection = new NtworkConexion(this, this);
        connection.execute();
    }

    @Override
    public void OnsubsuccesfullyResponse(String response) {
        ArrayList<Movie> peliculas = JsonParse.getMovies(this, response);
        int ifeje =0;

    }

    @Override
    public void OnfailedResponse() {

    }
}
