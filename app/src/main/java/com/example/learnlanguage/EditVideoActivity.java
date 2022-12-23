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
            binding.editBtn.setVisibility(View.VISIBLE);
            binding.addBtn.setVisibility(View.GONE);
            showData();
        }
        handleEditBtn();
    }

    private void showData() {
        binding.tilteTextTxt.setText(video.title);
        binding.descriptionTextTxt.setText(video.description);
        binding.channelNameTextTxt.setText(video.channelName);
        binding.numberofTextTxt.setText(video.numberOfViews);
        binding.uploadTimeTextTxt.setText(video.uploadedTime);
        binding.imageUrlTextTxt.setText(video.imageUrl);
        binding.channelLogoUrlTextTxt.setText(video.channelLogoUrl);
        binding.youtubeVideoIdTxt.setText(video.youtubeVideoId);
    }

    private void handleEditBtn() {
        binding.editBtn.setOnClickListener(view -> {
            String title = binding.tilteTextTxt.getText().toString();
            String description = binding.descriptionTextTxt.getText().toString();
            String channelName = binding.channelNameTextTxt.getText().toString();
            String numberOfViews = binding.numberofTextTxt.getText().toString();
            String uploadTime = binding.uploadTimeTextTxt.getText().toString();
            String imageUrl = binding.imageUrlTextTxt.getText().toString();
            String channelLogo = binding.channelLogoUrlTextTxt.getText().toString();
            String youtubeVideoId = binding.youtubeVideoIdTxt.getText().toString();
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
