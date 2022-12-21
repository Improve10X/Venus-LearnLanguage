package com.example.learnlanguage;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learnlanguage.api.VideosApi;
import com.example.learnlanguage.api.VideosService;

public class BaseActivity extends AppCompatActivity {

    protected VideosService videosService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupApiService();
    }

    protected void showToast(String video) {
        Toast.makeText(this, video, Toast.LENGTH_SHORT).show();
    }

    private void setupApiService() {
        VideosApi videosApi = new VideosApi();
        videosService =videosApi.createVideoService();
    }
}
