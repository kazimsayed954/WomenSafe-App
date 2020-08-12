package com.kazim.womensafe;

import android.os.Bundle;

public class ChatActivity extends DrawerDefault {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chat);
        getLayoutInflater().inflate(R.layout.activity_chat, frameLayout);
        navigationView.setCheckedItem(R.id.chatactivity);
        activityName = "chatactivity";
    }

}