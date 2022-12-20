package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class VideosActivity extends AppCompatActivity {

    private ArrayList<Video> videos;
    private RecyclerView videosRv;
    private VideosAdapter videosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        getSupportActionBar().setTitle("Videos");
        setupData();
        setupVideosRv();
        setupVideosAdapter();
    }

    private void setupData() {
        videos = new ArrayList<>();

        Video panda = new Video();
        panda.title = "Kung Fu Panda |";
        panda.description= "Who Are You";
        panda.uploadedTime = "12 Months";
        panda.numberOfViews = "12k views";
        panda.channelName = "Venus";
        panda.channelLogoUrl = "https://yt3.ggpht.com/ytc/AMLnZu_Qx8pZINayK8MHTCMpT2dH6xBNdGvwgFargUPF=s48-c-k-c0x00ffffff-no-rj";
        panda.imageUrl = "https://i.ytimg.com/an_webp/XbhecuoEgxs/mqdefault_6s.webp?du=3000&sqp=CKeahp0G&rs=AOn4CLDwRtSK_fG6gVIfWHaPG1iMKZodzg";
        videos.add(panda);
        videos.add(panda);
    }

    private void setupVideosRv() {
        videosRv = findViewById(R.id.videos_rv);
        videosRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupVideosAdapter() {
        videosAdapter = new VideosAdapter();
        videosAdapter.setVideos(videos);
        videosRv.setAdapter(videosAdapter);
    }
}