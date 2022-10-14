package com.example.mp_l_m_test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

// 2021 중간고사 문제 2번
public class MainActivity extends Activity {

    private EditText ed;
    private int count;
    private int selected;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ed = (EditText) findViewById(R.id.editText);
        selected = R.id.radioButton;
        
        RadioGroup g = (RadioGroup) findViewById(R.id.radioGroup);
        g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                selected = id;
                showNumber(); //메소드 호출 (16진수로 바꾸기 위해서)
            }
        });
    }

    public void click(View view) {
        if (view.getId() ==  R.id.button)
            count++;
        else
            count--;
        showNumber();
    }

    private void showNumber() {
        String s = null;
        switch (selected) {
            case R.id.radioButton:
                s = String.valueOf(count);
                break;
            case R.id.radioButton2:
                s = Integer.toHexString(count);
                break;
            case R.id.radioButton3:
                s = Integer.toBinaryString(count);
                break;
        }
        ed.setText(s);
    }
}
