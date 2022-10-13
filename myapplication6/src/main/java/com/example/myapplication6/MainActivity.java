package com.example.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;

//p.107     연습문제 21번
public class MainActivity extends Activity implements View.OnClickListener{
    private Random rand = new Random();
    private Button[] btns;
    private int[] colors = new int[5];  // int 배열 5개를 만듬.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        Button b_try= (Button) findViewById(R.id.btn0);
        btns = new Button[5];
        btns[0] = (Button) findViewById(R.id.btn1);
        btns[1] = (Button) findViewById(R.id.btn2);
        btns[2] = (Button) findViewById(R.id.btn3);
        btns[3] = (Button) findViewById(R.id.btn4);
        btns[4] = (Button) findViewById(R.id.btn5);

        b_try.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColors();
            }
        });
        setColors();    //try 버튼 누르기 전에 미리 색 나오도록.
        
        for (Button b : btns)
            b.setOnClickListener(this); //btns의 모든 버튼에 수신자를 달기
    }

    private void setColors() {
        for (int i=0; i<5; i++)
            btns[i].setBackgroundColor(colors[i] = rand.nextInt() | 0xff000000);    // or 연산
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;   //파라미타 view를 버튼으로 변경
        int i;
        for (i=0; i<5; i++)
            if(btns[i] == b)
                break;
        Toast.makeText(this, String.format("0x%06X", colors[i] & 0x00ffffff), Toast.LENGTH_LONG).show();
    }
}