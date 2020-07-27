package com.kazim.womensafe.FakeCall;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.kazim.womensafe.MainActivity2;
import com.kazim.womensafe.R;

public class FakeCallActivity extends AppCompatActivity {

    public RadioGroup radioGroup;
    public int afterTime;
    public String waitingTime, nio;
    EditText editName, editNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_call);
        editName = findViewById(R.id.edit_name);
        editNumber = findViewById(R.id.edit_phoneno);

        radioGroup = findViewById(R.id.rBtnGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rBtnNow) {
                    afterTime = 0;
                    waitingTime = "wait";
                } else if (checkedId == R.id.rBtnOne) {
                    afterTime = 15000;
                    waitingTime = "wait 15 sec";
                } else if (checkedId == R.id.rBtnFive) {
                    afterTime = 600000;
                    waitingTime = "wait 1 minute";
                } else if (checkedId == R.id.rBtnThirty) {
                    afterTime = 1800000;
                    waitingTime = "Wait 30 minutes";
                } else if (checkedId == R.id.rBtnHour) {
                    afterTime = 3600000;
                    waitingTime = "Wait 1 hour";
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        finish();
    }

    public void callBtnEvent(View view) {
        nio = editName.getText().toString();
        String number = editNumber.getText().toString();
        Toasty.normal(this, waitingTime, Toasty.LENGTH_SHORT).show();


        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        final Intent callintent = new Intent(this, FakeCallReceiver.class);
        callintent.putExtra("name", nio);
        callintent.putExtra("phone", number);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, callintent, 0);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + afterTime, pendingIntent);


//        Handler handler = new Handler();
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                callintent.putExtra("name",nio);
//                startActivity(callintent);
//
//            }
//        },afterTime);
    }
}