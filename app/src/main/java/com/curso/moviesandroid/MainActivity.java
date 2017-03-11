package com.curso.moviesandroid;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.curso.moviesandroid.com.curso.moviesandroid.network.NtworkConexion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NtworkConexion connection = new NtworkConexion(this);
        connection.execute();
    }
}
