package com.example.learnlanguage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        videosAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onDelete(String id) {
                deleteVideo(id);
            }

            @Override
            public void onEdit(Video video) {
                editVideo(video);
            }
        });
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

    private void deleteVideo(String id) {
        VideosApi videosApi = new VideosApi();
        VideosService videosService = videosApi.createVideoService();
        Call<Void> call = videosService.deleteVideo(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(VideosActivity.this, "Successfully deleted", Toast.LENGTH_SHORT).show();
                fetchVideos();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(VideosActivity.this, "failed to delete the video", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void editVideo(Video video) {
        Intent intent = new Intent(this, BaseAddEditVideoActivity.class);
        intent.putExtra("Video", video);
        startActivity(intent);
    }
}
