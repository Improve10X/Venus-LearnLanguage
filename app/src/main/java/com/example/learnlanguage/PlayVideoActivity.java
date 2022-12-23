package com.example.learnlanguage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnlanguage.databinding.ActivityPlayVideoBinding;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class PlayVideoActivity extends YouTubeBaseActivity {

    private ActivityPlayVideoBinding binding;
    private Video video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
            video = (Video) getIntent().getSerializableExtra(Constants.KEY_VIDEO);
            showData();
            setupYoutubeVideoPlayer();
    }

    private void setupYoutubeVideoPlayer() {
        binding.youtubePlayerView.initialize(Constants.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(video.youtubeVideoId);
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(PlayVideoActivity.this, "Failed to Youtube player", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showData() {
        binding.titleTxt.setText(video.title);
        binding.descriptionTxt.setText(video.description);
        binding.channelNameTxt.setText(video.channelName);
        binding.viewsTxt.setText(video.numberOfViews);
        binding.uploadTimeTxt.setText(video.uploadedTime);
        if(video.channelLogoUrl != null && video.channelLogoUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogoUrl).into(binding.channelLogoUrlTxt);
        }
    }
}