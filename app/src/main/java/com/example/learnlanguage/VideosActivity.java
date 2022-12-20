package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class VideosActivity extends AppCompatActivity {

    private ArrayList<Video> videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        getSupportActionBar().setTitle("Videos");
        setupData();
    }

    private void setupData() {
        videos = new ArrayList<>();

        Video panda = new Video();
        panda.name = "Kung Fu Panda";
        panda.description= "Who Are You";
        panda.postedDate = "12 Months";
        panda.numberOfViews = "12 k";
        panda.companyName = "Venus";
        panda.companyLogo = "https://yt3.ggpht.com/ytc/AMLnZu_Qx8pZINayK8MHTCMpT2dH6xBNdGvwgFargUPF=s48-c-k-c0x00ffffff-no-rj";
        panda.imageUrl = "https://i.ytimg.com/an_webp/XbhecuoEgxs/mqdefault_6s.webp?du=3000&sqp=CKeahp0G&rs=AOn4CLDwRtSK_fG6gVIfWHaPG1iMKZodzg";
        videos.add(panda);
        videos.add(panda);
    }
}