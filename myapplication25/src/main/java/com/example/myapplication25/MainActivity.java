package com.example.myapplication25;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
//16장 앱 바 p.94 + 과년도 기말고사 3번 문제풀이 진행함
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);  //메뉴를 띄어준다.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String s = null;
        switch (item.getItemId()) {
            case R.id.actino1: s = "ONE"; break;
            case R.id.actino2: s = "Two"; break;
            case R.id.actino3: s = "Three"; break;
        }
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        return true;
    }
}