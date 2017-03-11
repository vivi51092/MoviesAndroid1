package com.curso.moviesandroid.jsnon_utilities;

import android.content.Context;

import com.curso.moviesandroid.Models.Movie;
import com.curso.moviesandroid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 210206561 on 11/03/2017.
 */

public class JsonParse {
    public  static ArrayList<Movie> getMovies(Context context, String JsString){
        ArrayList<Movie> peliculas = new ArrayList<>();
        try {
            JSONObject objetoprincipal = new JSONObject(JsString);
            JSONArray arreglo_peliculas = objetoprincipal.getJSONArray(context.getString(R.string.results_json_param));
            for(int i = 0; i < arreglo_peliculas.length();i++){
                JSONObject pelicula = arreglo_peliculas.getJSONObject(i);
                int id = pelicula.getInt(context.getString(R.string.id_json_param));
                String title = pelicula.getString(context.getString(R.string.title_json_param));
                String description = pelicula.getString(context.getString(R.string.description_json_param));
                String poster_path = pelicula.getString(context.getString(R.string.poster_path_json_param));
                poster_path = "http://image.tmdb.org/t/p/"+
                        context.getString(R.string.image_size)+ "/"+ poster_path;

                Movie movie = new Movie(id, title,description,poster_path);
                peliculas.add(movie);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return peliculas;
    }
}
