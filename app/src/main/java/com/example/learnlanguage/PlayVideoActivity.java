package com.example.learnlanguage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class PlayVideoActivity extends YouTubeBaseActivity {

    private Video video;
    private ImageView channelLogoUrlTxt;
    private TextView titleTxt;
    private TextView descriptionTxt;
    private TextView channelNameTxt;
    private TextView viewsTxt;
    private TextView uploadTimeTxt;
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
            video = (Video) getIntent().getSerializableExtra(Constants.KEY_VIDEO);
            setupViews();
            showData();
            setupYoutubeVideoPlayer();
    }

    private void setupYoutubeVideoPlayer() {
        youTubePlayerView.initialize(Constants.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
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
        titleTxt.setText(video.title);
        descriptionTxt.setText(video.description);
        channelNameTxt.setText(video.channelName);
        viewsTxt.setText(video.numberOfViews);
        uploadTimeTxt.setText(video.uploadedTime);
        if(video.channelLogoUrl != null && video.channelLogoUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogoUrl).into(channelLogoUrlTxt);
        }
    }

    private void setupViews() {
        youTubePlayerView = findViewById(R.id.youtube_player_view);
        channelLogoUrlTxt = findViewById(R.id.channel_logo_url_txt);
        titleTxt = findViewById(R.id.title_txt);
        descriptionTxt = findViewById(R.id.description_txt);
        channelNameTxt = findViewById(R.id.channel_name_txt);
        viewsTxt = findViewById(R.id.views_txt);
        uploadTimeTxt = findViewById(R.id.upload_time_txt);
    }
}