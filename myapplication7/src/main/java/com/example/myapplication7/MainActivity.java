package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//교재 실습 p.48~51 (1)(2)(3)(4) 실습 + p.52 그리드뷰 실습
public class MainActivity extends Activity {
//    public static final String[] items = {
//            "one", "two", "three", "four", "five", "six", "seven", "one", "two", "three", "four",
//            "five", "six", "seven", "four", "five", "six", "seven"};   //src 준비, 문자 배열 만듬.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.items, R.layout.list_item);
//        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        //ListView lv = (ListView) findViewById(R.id.listView);
        GridView gv = (GridView) findViewById(R.id.gridView);
        gv.setAdapter(aa);
        //lv.setAdapter(aa);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        gv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });
    }
}