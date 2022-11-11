package com.example.myapplication13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//명시적 인텐트 실습 myapplication13
public class MainActivity extends Activity {

    private EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //p.68~70.  데이터 전달.  3) 예제
    public void f(View view) {
        ed = (EditText) findViewById(R.id.editText);
        int value = Integer.parseInt(ed.getText().toString());
        Intent intent = new Intent(this, NewActivity.class);    //인텐트 생성
        intent.putExtra("num", value);  //값을 new로 넘긴다.

        //startActivity(intent);  //인텐트 실행
        startActivityForResult(intent, 1234);
    }

    //p.72  (3)예제
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1234 && resultCode == RESULT_OK)
            ed.setText(String.valueOf(intent.getIntExtra("square", 0)));
        //requestcode, resultcode가 같으면 squre 값을 받는다. 넘겨준 데이터를 읽어온다. ("키 값", 디폴트 값)
    }
}