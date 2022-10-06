package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//p.29 Edit Text 실습
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int len = editText.getText().toString().length();
                Toast.makeText(MainActivity.this, String.valueOf(len), Toast.LENGTH_SHORT).show();  //onclick 안에 있어서 this 말고, MainActivity.this로 해주어야함.
                editText.setText("");
                editText.requestFocus();    //프로그램적으로 다시 포커스 요청
            }
        });
    }
}