package com.example.myapplication20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.*;
import java.text.SimpleDateFormat;
//연습문제 26번 b)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.textview);
        File f = new File(getFilesDir(), "last.bin");
        if (!f.exists())
            return;
        long tm = 0;
        try {
            DataInputStream dls = new DataInputStream(openFileInput("last.bin"));
            tm = dls.readLong();
            dls.close();
        } catch (IOException e) {}
        tv.setText("Last time = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tm));
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            DataOutputStream dos = new DataOutputStream(openFileOutput("last.bin", MODE_PRIVATE));
            dos.writeLong(System.currentTimeMillis());
            dos.close();
        } catch (IOException e) {}
    }
}