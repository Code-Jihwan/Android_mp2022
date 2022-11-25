package com.example.myapplication23;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

//날짜 선택 대화창 (p.90)
public class MainActivity extends AppCompatActivity {
    private DatePickerDialog dlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar cal = Calendar.getInstance();  //자동적으로 오늘 날짜의 달력이 뜨도록 하기 위해서

        dlg = new DatePickerDialog(this, null,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
    }

    public void f(View v) { //버튼 수신자 (버튼이 눌러지면 DatePickerDialog가 뜨도록 하기)
        dlg.show();
    }
}