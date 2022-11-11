package com.example.myapplication14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    //암시적 인텐트 실습 p.74
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void f (View view) {
        Uri uri = Uri.parse("https://m.ks.ac.kr");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        /*
        if(intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);*/
    }
}