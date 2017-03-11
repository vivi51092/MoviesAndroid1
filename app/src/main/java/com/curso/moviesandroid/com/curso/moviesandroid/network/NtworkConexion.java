package com.curso.moviesandroid.com.curso.moviesandroid.network;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.curso.moviesandroid.R;
import com.curso.moviesandroid.listener.NetworkConecctionInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by 210206561 on 11/03/2017.
 */

public class NtworkConexion  extends AsyncTask<Void, Void, Boolean>{

    private final String TAG =NtworkConexion.class.getSimpleName();
    private Context context;
    private String responseSTR;
    private NetworkConecctionInterface listener;
    public NtworkConexion(Context context, NetworkConecctionInterface network){
        this.context = context;
        this.listener = network;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        final String BASE_URL = "http://api.themoviedb.org/3/movie";
        final String POPULAR_PATH = "popular";
        final String API_KEY_PARAM ="api_key";

        //Construccion de URL
        Uri uri1 = Uri.parse(BASE_URL).buildUpon().appendPath(POPULAR_PATH).appendQueryParameter(API_KEY_PARAM,context.getString(R.string.api_key_value)).build();
        HttpURLConnection urlConnection ;
        BufferedReader reader;
        Log.d(TAG, uri1.toString());

        try {
            URL url = new URL(uri1.toString());
            try {
                urlConnection = (HttpURLConnection)url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();


                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer stringBuffer = new StringBuffer();

                if(inputStream == null){
                    return false;
                }

                //validacion a no coneccion
                reader = new BufferedReader(new InputStreamReader(inputStream));
                //Lectura del InputStream
                String line;
                while ((line = reader.readLine())!= null){
                    stringBuffer.append(line + "\n");//Se aneza linea
                }
                if(stringBuffer.length() ==0){
                    return false; //la cadena esta vacia
                }
                responseSTR = stringBuffer.toString();
                Log.d(TAG,"Server response: "+ responseSTR);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(TAG,e.toString());
                return false;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e(TAG,e.toString());
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if(result){
            if(listener != null){
                listener.OnsubsuccesfullyResponse(responseSTR);
            }
        }else{
            if(listener !=null){
                listener.OnfailedResponse();
            }
        }
    }

}
