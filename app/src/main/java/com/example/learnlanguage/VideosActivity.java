package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideosActivity extends AppCompatActivity {

    private ArrayList<Video> videos = new ArrayList<>();
    private RecyclerView videosRv;
    private VideosAdapter videosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        getSupportActionBar().setTitle("Videos");
        setupVideosRv();
        setupVideosAdapter();
        handleAdd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchVideos();
    }

    private void handleAdd() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, BaseAddEditVideoActivity.class);
            startActivity(intent);
        });
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


    private void fetchVideos() {
        VideosApi videosApi = new VideosApi();
        VideosService videosService = videosApi.createVideoService();
        Call<List<Video>> call = videosService.fetchVideos();
        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                List<Video> videos = response.body();
                videosAdapter.setVideos(videos);
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Toast.makeText(VideosActivity.this, "Failed to fetch videos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
