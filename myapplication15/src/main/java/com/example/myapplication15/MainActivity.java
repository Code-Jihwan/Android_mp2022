package com.example.myapplication15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("HJ", "Main_onCreate");
    }

    public void f(View view) {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("HJ","Main_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("HJ","Main_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("HJ","Main_onStop");
    }
}