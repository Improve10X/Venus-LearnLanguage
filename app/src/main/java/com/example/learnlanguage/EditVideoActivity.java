package com.example.learnlanguage;

import android.os.Bundle;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditVideoActivity extends BaseAddEditVideoActivity {

    private Video video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().hasExtra(Constants.KEY_VIDEO)) {
            getSupportActionBar().setTitle("Edit Activity");
            video = (Video) getIntent().getSerializableExtra(Constants.KEY_VIDEO);
            editBtn.setVisibility(View.VISIBLE);
            addBtn.setVisibility(View.GONE);
            showData();
        }
        handleEditBtn();
    }

    private void showData() {
        titleTextTxt.setText(video.title);
        descriptionTextTxt.setText(video.description);
        channelNameTextTxt.setText(video.channelName);
        numberOfViewsTextTxt.setText(video.numberOfViews);
        uploadTimeTextTxt.setText(video.uploadedTime);
        imageUrlTextTxt.setText(video.imageUrl);
        channelLogoTextTxt.setText(video.channelLogoUrl);
        youtubeVideoIdTxt.setText(video.youtubeVideoId);
    }

    private void handleEditBtn() {
        editBtn.setOnClickListener(view -> {
            String title = titleTextTxt.getText().toString();
            String description = descriptionTextTxt.getText().toString();
            String channelName = channelNameTextTxt.getText().toString();
            String numberOfViews = numberOfViewsTextTxt.getText().toString();
            String uploadTime = uploadTimeTextTxt.getText().toString();
            String imageUrl = imageUrlTextTxt.getText().toString();
            String channelLogo = channelLogoTextTxt.getText().toString();
            String youtubeVideoId = youtubeVideoIdTxt.getText().toString();
            updateVideo(video.id, title, description, channelName, numberOfViews, uploadTime, imageUrl, channelLogo, youtubeVideoId);
        });
    }

    private void updateVideo(String id, String title, String description, String channelName, String numberOfViews, String uploadTime, String imageUrl, String channelLogo, String youtubeVideoId) {
        Video video = new Video();
        video.title = title;
        video.description = description;
        video.channelName = channelName;
        video.numberOfViews = numberOfViews;
        video.uploadedTime = uploadTime;
        video.imageUrl = imageUrl;
        video.channelLogoUrl = channelLogo;
        video.youtubeVideoId = youtubeVideoId;

        Call<Void> call = videosService.updateVideo(id, video);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully updated the video");
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to update the video");
            }
        });
    }
}
