package com.kazim.womensafe.FakeCall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

import com.kazim.womensafe.R;

public class CallScreenActivity extends AppCompatActivity {

    public MediaPlayer player;

    public TextView textView, textView2;

    String val, val1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_screen);

        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();
        //backgroundMusicEnd

        textView = (TextView) findViewById(R.id.textView4);
        textView2 = findViewById(R.id.textView5);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            val = bundle.getString("name");
            val1 = bundle.getString("phone");
            textView.setText(val);
            textView2.setText(val1);

        }

    }

    public void acceptCall(View view) {
        Intent acceptCall = new Intent(this, AcceptCallScreen.class);
        acceptCall.putExtra("name", val);
        acceptCall.putExtra("phone", val1);
        startActivity(acceptCall);
        player.stop();
        finish();
    }

    @Override
    public void onBackPressed() {
        player.stop();
        finish();
    }

    public void endCall(View view) {

        player.stop();
        finish();

    }
}