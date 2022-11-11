package com.example.myapplication13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//명시적 인텐트 실습 myapplication13
public class NewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //넘겨준 데이터를 받을 때  (p.68~70) Main -> New

        Intent intent = getIntent();    //인텐트 객체를 얻는다.
        int n = intent.getIntExtra("num", 0);   //넘어온 num을 받는다.
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(String.valueOf((n)));

/*
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(String.valueOf(getIntent().getIntExtra("num", 0)));
*/

        //p.72  (3) 예제
        intent.putExtra("square", n*n);  //New에서 Main으로 다시 값 전달
        setResult(RESULT_OK, intent);

        //버튼 누르면 finish() 호출.  p.66 [연습]
        Button b = (Button) findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
