package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
// mp2022   09.23
// 체크박스 예제 (p.19 ~ 21)    익명의 내부 수신자 사용  View.OnClickListener()  /  CompoundButton.OnCheckedChangeListener() 사용.
public class MainActivity extends AppCompatActivity {
    private CheckBox[] cbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbs = new CheckBox[3];
        cbs[0] = (CheckBox) findViewById(R.id.checkbox1);
        cbs[1] = (CheckBox) findViewById(R.id.checkbox2);
        cbs[2] = (CheckBox) findViewById(R.id.checkbox3);

        for (CheckBox cb : cbs)
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    String s = "";
                    for (CheckBox cb : cbs)
                        if (cb.isChecked())
                            s += cb.getText();
                    if (s.length() > 0)
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                }
            });
/*
            // OnClickListener() 수신자 사용.
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = " ";
                    for (CheckBox cb : cbs)
                        if (cb.isChecked())
                            s += cb.getText();
                    if (s.length() > 0)
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                }
            });
*/
    }
}

// View.OnClickListener() 수신자는 버튼에서만 사용. 눌러졌을 떄 호출    onClick() 메소드
// CompoundButton.OnCheckedChangeListener() 수신자는 체크박스에서 사용. 상태가 변화했을 때 호출   onCheckedChanged() 메소드