package com.example.myapplication18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        //int z = intent.getIntExtra("color", 0);
        TextView tv = (TextView) findViewById(R.id.textview);
        tv.setText("Hex Code = " + String.valueOf(intent.getIntExtra("color", 0)));
        int z = intent.getIntExtra("color", 0);

        TextView tv0 = (TextView) findViewById(R.id.textview0);
        tv0.setTextColor(z);
        //tv0.setTextColor(Color.parseColor(String.valueOf(z)));
    }
}