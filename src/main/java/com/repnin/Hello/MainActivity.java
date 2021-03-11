package com.repnin.Hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ed1x = findViewById(R.id.edit1x),
                ed1y = findViewById(R.id.edit1y),
                ed2x = findViewById(R.id.edit2x),
                ed2y = findViewById(R.id.edit2y),
                ed3x = findViewById(R.id.edit3x),
                ed3y = findViewById(R.id.edit3y);
        Button b1 = findViewById(R.id.button1);
        TextView textP = findViewById(R.id.text1),
                textS = findViewById(R.id.text2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double x1 = Double.parseDouble(ed1x.getText().toString()),
                        x2 = Double.parseDouble(ed2x.getText().toString()),
                        x3 = Double.parseDouble(ed3x.getText().toString()),
                        y1 = Double.parseDouble(ed1y.getText().toString()),
                        y2 = Double.parseDouble(ed2y.getText().toString()),
                        y3 = Double.parseDouble(ed3y.getText().toString()),
                        ab = Math.hypot(x1 - x2, y1 - y2),
                        bc = Math.hypot(x2 - x3, y2 - y3),
                        ac = Math.hypot(x1 - x3, y1 - y3),
                        P = ab + bc + ac,
                        p = P/2,
                        s = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
                textP.setText(String.format("%.9f", P));
                textS.setText(String.format("%.9f", s));
            }
        });
    }

}