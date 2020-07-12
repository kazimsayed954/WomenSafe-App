package com.kazim.womensafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

public class SelfdefenceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<videoModel> youtubeVideos = new Vector<videoModel>();
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfdefence);

        title = findViewById(R.id.title);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));


        title.setText(Constants.tips);

        youtubeVideos.add( new videoModel("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/M4_8PoRQP8w\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new videoModel("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KVpxP3ZZtAc\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new videoModel("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/T7aNSRoDCmg\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new videoModel("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Ww1DeUSC94o\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new videoModel("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/1O5J19lhGwg\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
    }

    public void tips(View view) {

        //Toast.makeText(getApplicationContext(),"Visibility"+title.getVisibility(),Toast.LENGTH_SHORT).show();

        int V= title.getVisibility();
        if(V == 8){

            title.setVisibility(View.VISIBLE);
        }

        if(V == 0){

            title.setVisibility(View.GONE);
        }
    }

    public void tips_in_video(View view) {

        int R= recyclerView.getVisibility();
        if(R == 8){

            recyclerView.setVisibility(View.VISIBLE);
        }

        if(R == 0){

            recyclerView.setVisibility(View.GONE);
        }
    }
}