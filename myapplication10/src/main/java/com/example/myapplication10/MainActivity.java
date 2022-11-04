package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

//연습문제 19번  p.106
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button[] btns = new Button[4];
    private MyView mv;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        linear.addView(new MyView(this));

        btns[0] = (Button) findViewById(R.id.button);
        btns[1] = (Button) findViewById(R.id.button2);
        btns[2] = (Button) findViewById(R.id.button3);
        btns[3] = (Button) findViewById(R.id.button4);

        for (int i=0; i<4; i++)
            btns[i].setOnClickListener(this);   //수신자 달기, 자기 수신자, 어떤 버튼이든 누르면 수신자가 호출이 된다. 수신자를 1개만 둠
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) { //눌러진 버튼 알아내기
            case R.id.button:
                mv.left();
                break; //Myview의 left 메소드 호출
            case R.id.button2:
                mv.up();
                break;
            case R.id.button3:
                mv.down();
                break;
            case R.id.button4:
                mv.right();
                break;
        }
    }
}