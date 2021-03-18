package com.repnin.matrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView t1 = findViewById(R.id.text1);
        Button b2 = findViewById(R.id.button2);
        Intent received = getIntent();
        int size = (int)received.getExtras().get("key");
        t1.setText(t1.getText().toString() + String.valueOf(size));
        ArrayList<ArrayList<EditText>> ed = new ArrayList<ArrayList<EditText>>();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed.clear();
                GridLayout grid = findViewById(R.id.grid);
                grid.removeAllViews();
                grid.setColumnCount(size);
                grid.setRowCount(size);
                Random rand = new Random();
                for(int i = 0; i < size; ++i){
                    ed.add(new ArrayList<EditText>());
                    for(int j = 0; j < size; ++j){
                        EditText tmp = new EditText(MainActivity2.super.getApplicationContext());
                        tmp.setText(String.valueOf(rand.nextInt(201) - 100));
                        tmp.setId(i*10+j);
                        ed.get(i).add(tmp);
                        grid.addView(tmp);
                    }
                }
            }
        };
        b2.setOnClickListener(listener);
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder res = new StringBuilder();
                for(int i = 0; i < size; ++i){
                    int even;
                    even = 0;
                    for(EditText j : ed.get(i)){
                        if(Integer.parseInt(j.getText().toString()) % 2 == 0)
                            even++;
                    }
                    if(even == size)
                        res.append(String.valueOf(i + 1) + " ");
                }
                Toast.makeText(MainActivity2.this, res.toString(), Toast.LENGTH_LONG).show();
            }
        };
        Button calc = findViewById(R.id.cal);
        calc.setOnClickListener(listener);
    }
}
