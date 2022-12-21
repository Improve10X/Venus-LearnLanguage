package com.example.learnlanguage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideosActivity extends BaseActivity {

    private ArrayList<Video> videos = new ArrayList<>();
    private RecyclerView videosRv;
    private VideosAdapter videosAdapter;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        getSupportActionBar().setTitle("Videos");
        setupViews();
        setupVideosRv();
        setupVideosAdapter();
        handleAdd();
    }

    private void setupViews() {
        addBtn = findViewById(R.id.add_btn);
        videosRv = findViewById(R.id.videos_rv);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchVideos();
    }

    private void handleAdd() {
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddVideoActivity.class);
            startActivity(intent);
        });
    }

    private void setupVideosRv() {
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
        Call<List<Video>> call = videosService.fetchVideos();
        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                List<Video> videos = response.body();
                videosAdapter.setVideos(videos);
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                showToast("Failed to load the Videos");
            }
        });
    }

    private void deleteVideo(String id) {
        Call<Void> call = videosService.deleteVideo(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
               showToast("Successfully deleted the Video");
                fetchVideos();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("failed to delete the video");
            }
        });
    }

    private void editVideo(Video video) {
        Intent intent = new Intent(this, EditVideoActivity.class);
        intent.putExtra(Constants.KEY_VIDEO, video);
        startActivity(intent);
    }
}
