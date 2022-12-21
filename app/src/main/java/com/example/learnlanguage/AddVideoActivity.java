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
        addVideoBtn();
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
            setupAddVideo(title, description, channelName, numberOfViews, uploadTime, imageUrl, channelLogo);
        });
    }

    private void setupAddVideo(String title, String description, String channelName, String numberOfViews, String uploadTime, String imageUrl, String channelLogo) {
        Video video = new Video();
        video.title = title;
        video.description = description;
        video.channelName = channelName;
        video.numberOfViews = numberOfViews;
        video.uploadedTime = uploadTime;
        video.imageUrl = imageUrl;
        video.channelLogoUrl = channelLogo;

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
