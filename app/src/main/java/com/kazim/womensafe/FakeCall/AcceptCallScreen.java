package com.kazim.womensafe.FakeCall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import com.kazim.womensafe.R;

public class AcceptCallScreen extends AppCompatActivity {

    public Chronometer chronometer;
    TextView textView, textView2;
    String val, val1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_call_screen);
        textView = findViewById(R.id.textView4);
        textView2 = findViewById(R.id.textView5);
        chronometer = (Chronometer) findViewById(R.id.chronometer2);
        chronometer.start();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            val = bundle.getString("name");
            val1 = bundle.getString("phone");
            textView.setText(val);
            textView2.setText(val1);

        }


    }

    public void quitCallEvent(View view) {
        finish();
    }
}