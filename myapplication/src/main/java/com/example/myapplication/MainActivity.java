package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

//xml 파일 사용하여 화면에 여러 개의 텍스트 뷰 보이기  (mp2022  p.8)   22.09.15
public class MainActivity extends Activity {

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

        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {      //익명의 내부 클래스 수신자로 구현 (22.09.22)
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello!!!!!!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    // MyListener를 내부 클래스로 구현 (mp2022) 22.09.22
/*    private class MyListener implements View.OnClickListener {
    }
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Hello!!!!!!!", Toast.LENGTH_LONG).show();
    }*/
}

/*
수신자 종류
1. 별도 수신자 (외부에 수신자 따로 만듬)
2. 내부 클래스로 수신자
3. 익명의 내부 클래스 수신자
4. 자기 수신자
5. xml로 지정
*/


/* 버튼, 텍스트 불러오고 익명의 내부 클래스 쓰고, flout size = tv.getTextSize() 위에 선언, size 지역변수를 다른 클래스에서 쓰기위해서는 전역변수로 선언 Private flout size;
onClick 안에다가  버튼이 눌러지면 size+=5;  tv.setTextSize(size);
*/