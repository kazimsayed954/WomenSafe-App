package com.kazim.womensafe;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.kazim.womensafe.FakeCall.FakeCallActivity;

public class DrawerDefault extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public DrawerLayout drawer;
    public NavigationView navigationView;
    private FirebaseAuth auth;
    private FirebaseUser user;
    public FrameLayout frameLayout;
    public String activityName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_activity_drawer);
        frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        //Firebase for user authentication
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        //Set Custom Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);
           navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        addDetails();

    }

//    private void highlight(int res) {
//        navigationView.setCheckedItem(res);
//    }

    private void addDetails() {
        String headname = user.getDisplayName();
        String headmail = user.getEmail();
        View headerView = navigationView.getHeaderView(0);
        TextView tvheadname = headerView.findViewById(R.id.header_name);
        TextView tvheadmail = headerView.findViewById(R.id.header_email);
//        Toast.makeText(this, headname, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, headmail, Toast.LENGTH_SHORT).show();
//
        if (!(TextUtils.isEmpty(headname))) {
            tvheadname.setText(headname);
        }
        if (!(TextUtils.isEmpty(headmail))) {
            tvheadmail.setText(headmail);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.signout:
                auth.signOut();
                Intent myIntent = new Intent(this, LoginActivity.class);
                this.startActivity(myIntent);
                finish();
                break;
            case R.id.changepswrd:
                auth.signOut();
                Intent myIntent1 = new Intent(this, ForgotActivity.class);
                this.startActivity(myIntent1);
                finish();
                break;
            case R.id.sosactivity:
                if(activityName=="mainactivity2")break;
                else{
                Intent myIntent2 = new Intent(this, MainActivity2.class);
                this.startActivity(myIntent2);
                break;}
            case R.id.chatactivity:
                if(activityName=="chatactivity")break;
                else{
                Intent myIntent3 = new Intent(this, ChatActivity.class);
                this.startActivity(myIntent3);
                break;}
            case R.id.fakecallactivity:
                if(activityName=="fakeactivity")break;
                else{
                Intent myIntent4 = new Intent(this, FakeCallActivity.class);
                this.startActivity(myIntent4);
                break;}
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

}
