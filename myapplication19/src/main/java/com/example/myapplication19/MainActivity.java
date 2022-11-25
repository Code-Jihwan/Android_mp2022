package com.example.myapplication19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.io.*;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textview);
        String s;
        if (writeFile())
            s = getFileInfo();
        else
            s = "Can't write file";
        tv.setText(s);
    }

    private String getFileInfo() {
        File f = new File(getFilesDir(),"test.bin");
        String s = "";
        if (f.exists()) {
            s += "Path = "  + f.getAbsolutePath();
            s += "\nLength = " + String.valueOf(f.length());
            s += "\nDate = " + new Date(f.lastModified()).toString();
        }
        else
            s += "File Not Found";
        return s;
    }

    private boolean writeFile() {
        try {
            FileOutputStream fos = openFileOutput("test.bin", MODE_PRIVATE);
            for (int i =0; i<10; i++)
                fos.write(i);
            fos.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}