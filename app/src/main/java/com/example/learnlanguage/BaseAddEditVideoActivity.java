package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseAddEditVideoActivity extends AppCompatActivity {

    private Button addBtn;
    private EditText titleTextTxt;
    private EditText descriptionTextTxt;
    private EditText channelNameTextTxt;
    private EditText numberOfViewsTextTxt;
    private EditText uploadTimeTextTxt;
    private EditText imageUrlTextTxt;
    private EditText channelLogoTextTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_add_edit_video);
        getSupportActionBar().setTitle("Add Activity");
        setUpViews();
        addVideoBtn();
    }

    private void setUpViews() {
       addBtn = findViewById(R.id.add_btn);
        titleTextTxt = findViewById(R.id.tilte_text_txt);
        descriptionTextTxt = findViewById(R.id.description_text_txt);
        channelNameTextTxt = findViewById(R.id.channel_name_text_txt);
        numberOfViewsTextTxt = findViewById(R.id.numberof_text_txt);
        uploadTimeTextTxt = findViewById(R.id.upload_time_text_txt);
        imageUrlTextTxt = findViewById(R.id.image_url_text_txt);
        channelLogoTextTxt = findViewById(R.id.channel_logo_url_text_txt);
    }

    private void addVideoBtn() {
        addBtn.setOnClickListener(view -> {
            String title = titleTextTxt.getText().toString();
            String description = descriptionTextTxt.getText().toString();
            String channelName = channelNameTextTxt.getText().toString();
            String numberOfViews = numberOfViewsTextTxt.getText().toString();
            String uploadTime = uploadTimeTextTxt.getText().toString();
            String imageUrl = imageUrlTextTxt.getText().toString();
            String channelLogo = channelLogoTextTxt.getText().toString();
            setupAddVideo(title, description, channelName, numberOfViews, uploadTime, imageUrl, channelLogo );
        });
    }

    private void setupAddVideo(String title, String description, String channelName, String numberOfViews, String uploadTime, String imageUrl, String channelLogo ) {
        Video video = new Video();
        video.title = title;
        video.description = description;
        video.channelName = channelName;
        video.numberOfViews = numberOfViews;
        video.uploadedTime = uploadTime;
        video.imageUrl = imageUrl;
        video.channelLogoUrl = channelLogo;

        VideosApi videosApi = new VideosApi();
        VideosService videosService = videosApi.createVideoService();
        Call<Video> call = videosService.createVideo(video);
        call.enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Call<Video> call, Response<Video> response) {
                Toast.makeText(BaseAddEditVideoActivity.this, "Success", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Video> call, Throwable t) {
                Toast.makeText(BaseAddEditVideoActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}