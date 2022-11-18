package com.example.myapplication17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

//연습문제 27번
public class MainActivity extends AppCompatActivity {
    public static final String[] colors = {"Red", "Oreange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
    public static final int[] codes = {0xffff0000, 0xffffa500, 0xffffff00, 0xff00ff00, 0xff0000ff, 0xff4b0082, 0xff7f00ff};
    private int position;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         prefs = getSharedPreferences("jh", MODE_PRIVATE);
         position = prefs.getInt("position", 0);

        LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, colors);

        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                linear.setBackgroundColor(codes[position=i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        sp.setSelection(position);
    }
    @Override
    protected void onStop() {   //앱이 끝나기 전에 호출 됨
        super.onStop();
        prefs.edit().putInt("position",position).commit();   //포지션 값 저장 (저장=commit)

    }
}//공유 프레퍼런스에는 간단한 환경설정 값을 저장하는데 좋음.