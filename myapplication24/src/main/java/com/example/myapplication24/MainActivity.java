package com.example.myapplication24;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

//시간 선택 대화창 (p.91)
public class MainActivity extends Activity implements TimePickerDialog.OnTimeSetListener {
    private int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar cal = Calendar.getInstance();   //Calender 객체가 만들어짐

        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
    }

    public void f(View v) { //버튼 수신자 (버튼이 눌러지면 DatePickerDialog가 뜨도록 하기)
        new TimePickerDialog(this, this, hour, minute, false).show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        Toast.makeText(this, String.format("%02d:%02d", i, i1), Toast.LENGTH_LONG).show();  //i=hour, i1=minute
    }
}