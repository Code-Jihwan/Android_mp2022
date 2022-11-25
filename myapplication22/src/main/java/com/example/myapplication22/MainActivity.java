package com.example.myapplication22;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//책 p.89 (대화창 실습)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void f(View v) {
        DialogInterface.OnClickListener listener;   //수신자 통합하기 (버튼마다 수신자 두지 말고)
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ku_logo)
                .setTitle("Hello")
                .setMessage("Do you love me?")
                .setPositiveButton("OK", listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String s = null;
                        if (which == DialogInterface.BUTTON_POSITIVE)
                            s = "I see";
                        else if (which == DialogInterface.BUTTON_NEGATIVE)
                            s = "Sorry";
                        else if (which == DialogInterface.BUTTON_NEUTRAL)
                            s = "몰루?";
                        Toast.makeText(MainActivity.this, String.valueOf(s), Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("No", listener)
                .setNeutralButton("Cancel", listener)
                .show();
    }
}