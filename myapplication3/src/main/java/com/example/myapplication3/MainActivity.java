package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

//p.22 토글 버튼
//익명의 내부 클래스 수신자
public class MainActivity extends Activity {
    ToggleButton[] tbs; //전역변수로 바꿈

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbs = new ToggleButton[3];
        tbs[0] = (ToggleButton) findViewById(R.id.tg1);
        tbs[1] = (ToggleButton) findViewById(R.id.tg2);
        tbs[2] = (ToggleButton) findViewById(R.id.tg3);

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String s = "";
                for (int i=0; i<3; i++)
                    if (tbs[i].isChecked())
                        s += i + 1;     // i 가 자동으로 string으로 바뀜.
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }
        };

        for (ToggleButton tb : tbs)     //tbs 배열에 들어있는 모든 tb에 대해 수신자를 설정
            tb.setOnCheckedChangeListener(listener);
    }
}

/*
자기 수신자
public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener {
    ToggleButton[] tbs; //전역변수로 바꿈

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbs = new ToggleButton[3];
        tbs[0] = (ToggleButton) findViewById(R.id.tg1);
        tbs[1] = (ToggleButton) findViewById(R.id.tg2);
        tbs[2] = (ToggleButton) findViewById(R.id.tg3);

        for (int i=0; i<3; i++)
            tbs[i].setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String s = "";
        for (int i=0; i<3; i++)
            if (tbs[i].isChecked())
                s += i + 1;     // i 가 자동으로 string으로 바뀜.
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }
}
*/
