package com.androidstudy_mp2022;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

//1.화면에 여러 개의 텍스트 뷰 보이기  (mp2022  p.6)   22.09.15
public class MainActivity2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView textView1 = new TextView(this);
        TextView textView2 = new TextView(this);
        TextView textView3 = new TextView(this);

        textView1.setText("Hello");
        textView1.setTextSize(25);
        textView1.setTypeface(null, Typeface.ITALIC);
        textView2.setText("Android");
        textView2.setTextSize(25);
        textView3.setText("Programming");
        textView3.setTextSize(25);

        linearLayout.addView(textView1);
        linearLayout.addView(textView2);
        linearLayout.addView(textView3);

        setContentView(linearLayout);
    }
}
