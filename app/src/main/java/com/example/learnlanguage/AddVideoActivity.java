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
        binding.editBtn.setVisibility(View.GONE);
        binding.addBtn.setVisibility(View.VISIBLE);
        handleAddBtn();
    }

    private void handleAddBtn() {
        binding.editBtn.setOnClickListener(view -> {
            String title = binding.tilteTextTxt.getText().toString();
            String description = binding.descriptionTextTxt.getText().toString();
            String channelName = binding.channelNameTextTxt.getText().toString();
            String numberOfViews = binding.numberofTextTxt.getText().toString();
            String uploadTime = binding.uploadTimeTextTxt.getText().toString();
            String imageUrl = binding.imageUrlTextTxt.getText().toString();
            String channelLogoUrl = binding.channelLogoUrlTextTxt.getText().toString();
            String youtubeVideoId = binding.youtubeVideoIdTxt.getText().toString();
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
