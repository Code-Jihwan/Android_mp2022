package com.example.mp_final_test2021;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
//2021 기말고사 2번 문제
public class MainActivity extends Activity {

    private EditText ed;
    @Override

    protected void onCreate(Bundle savedInstanceState)

    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ed = (EditText)findViewById(R.id.editText);



        String addr = getSharedPreferences("hj", MODE_PRIVATE).getString("addr", "");

        if (addr.length() > 0)  //주소가 들어있으면

            ed.setText(addr);

    }



    public void f(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + ed.getText().toString()));

        //if (intent.resolveActivity(getPackageManager()) != null)  //없는게 아니면 실행해라.
        startActivity(intent);

    }

    @Override

    protected void onStop() {

        super.onStop();

        getSharedPreferences("hj", MODE_PRIVATE).edit().putString("addr", ed.getText().toString()).commit();

    }

}