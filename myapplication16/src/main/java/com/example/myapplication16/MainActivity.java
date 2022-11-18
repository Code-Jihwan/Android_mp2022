package com.example.myapplication16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
//공유 프레퍼런스 p.81~82 | p.111 (연습문제 26번)
public class MainActivity extends AppCompatActivity {
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.textView);
        prefs = getSharedPreferences("hj", MODE_PRIVATE);
        long time = prefs.getLong("last", 0); //키 값, 디폴트 값
        if (time > 0)
            //tv.setText("Last time = " + new Date(time).toString()); (11월17일목)
            tv.setText("Last time = " + new SimpleDateFormat("yyyy-MM-dd-HH:mm-ss").format(time));  //연습문제26번
    }

    @Override
    protected void onStop() {   //앱이 끝나면 onStop이 호출
        super.onStop();
        long time = System.currentTimeMillis();//이거를 공유 프리퍼런스에 넣기
        SharedPreferences.Editor editor = getSharedPreferences("hj", 0).edit();
        editor.putLong("last", time); //키 값, 현재 시간
        editor.commit();
        //prefs.edit().putLong("last",System.currentTimeMillis()).commit();
    }
}