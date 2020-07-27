package com.kazim.womensafe.FakeCall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FakeCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String getFakeName = intent.getStringExtra("name");
        String getFakePhoneNumber = intent.getStringExtra("phone");

        Intent intentObject = new Intent(context.getApplicationContext(), CallScreenActivity.class);
        intentObject.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intentObject.putExtra("name", getFakeName);
        intentObject.putExtra("phone", getFakePhoneNumber);
        context.startActivity(intentObject);
    }
}
