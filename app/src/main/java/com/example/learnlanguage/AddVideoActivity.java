package com.example.learnlanguage;

import android.os.Bundle;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddVideoActivity extends BaseAddEditVideoActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Video");
        editBtn.setVisibility(View.GONE);
        addBtn.setVisibility(View.VISIBLE);
        handleAddBtn();
    }

    private void handleAddBtn() {
        addBtn.setOnClickListener(view -> {
            String title = titleTextTxt.getText().toString();
            String description = descriptionTextTxt.getText().toString();
            String channelName = channelNameTextTxt.getText().toString();
            String numberOfViews = numberOfViewsTextTxt.getText().toString();
            String uploadTime = uploadTimeTextTxt.getText().toString();
            String imageUrl = imageUrlTextTxt.getText().toString();
            String channelLogoUrl = channelLogoTextTxt.getText().toString();
            String youtubeVideoId = youtubeVideoIdTxt.getText().toString();
            addVideo(title, description, channelName, numberOfViews, uploadTime, imageUrl, channelLogoUrl, youtubeVideoId);
        });
    }

    private void addVideo(String title, String description, String channelName, String numberOfViews, String uploadTime, String imageUrl, String channelLogoUrl, String youtubeVideoId) {
        Video video = new Video();
        video.title = title;
        video.description = description;
        video.channelName = channelName;
        video.numberOfViews = numberOfViews;
        video.uploadedTime = uploadTime;
        video.imageUrl = imageUrl;
        video.channelLogoUrl = channelLogoUrl;
        video.youtubeVideoId = youtubeVideoId;

        Call<Video> call = videosService.createVideo(video);
        call.enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Call<Video> call, Response<Video> response) {
                showToast("Successfully added the Video");
                finish();
            }

            @Override
            public void onFailure(Call<Video> call, Throwable t) {
                showToast("Failed to add the Video");
            }
        });
    }
}
