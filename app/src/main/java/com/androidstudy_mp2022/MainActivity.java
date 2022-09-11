package com.androidstudy_mp2022;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

//1.화면에 한 개의 텍스트 뷰 보이기  (mp2022  p.5)   22.09.08
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("Hello World!!");
        textView.setTextSize(50);
        setContentView(textView);
    }
}