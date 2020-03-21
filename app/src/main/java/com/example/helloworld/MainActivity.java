package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.Image;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.util.Log;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myListView = (ListView)findViewById(R.id.myListView);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        final EditText et1 = findViewById(R.id.et1);
        final EditText et2 = findViewById(R.id.et2);
        final EditText et3 = findViewById(R.id.et3);
        final ArrayList<String> todoItems = new ArrayList<String>();
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
        myListView.setAdapter(aa);
        et1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int i, KeyEvent keyevent) {
                if(keyevent.getAction() == KeyEvent.ACTION_DOWN)
                    if((i==KeyEvent.KEYCODE_DPAD_CENTER)||(i==KeyEvent.KEYCODE_ENTER)){
                        todoItems.add(0, et1.getText().toString());
                        aa.notifyDataSetChanged();
                        et1.setText("");
                        Log.d("MainActivity", "world");
                        return true;
                    }
                Log.d("MainActivity", "hello");
                return false;

            }
        });

    }
}
