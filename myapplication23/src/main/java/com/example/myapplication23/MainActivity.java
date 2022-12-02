package com.example.myapplication23;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

//날짜 선택 대화창 (p.90)
public class MainActivity extends Activity implements DatePickerDialog.OnDateSetListener {
    private DatePickerDialog dlg;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar cal = Calendar.getInstance();  //자동적으로 오늘 날짜의 달력이 뜨도록 하기 위해서   //Calender 객체가 만들어짐

        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
    }

    public void f(View v) { //버튼 수신자 (버튼이 눌러지면 DatePickerDialog가 뜨도록 하기)
        new DatePickerDialog(this, this, year, month, day).show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Toast.makeText(this, String.format("%04d-%02d-%02d", i, i1+1, i2), Toast.LENGTH_LONG).show();
        //i=year, i1=month (달은 0부터 시작하니깐 +1 해주어야 한다), i2=day
    }
}