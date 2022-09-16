package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

//xml 파일 사용하여 화면에 여러 개의 텍스트 뷰 보이기  (mp2022  p.8)   22.09.15
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        tv1.setText("1111");
        tv2.setText("2222");

        //Toast 출력 (토스트 객체 생성)  p.12
        Toast.makeText(this, "Toast 메세지 입니다.", Toast.LENGTH_LONG).show();
    }
}