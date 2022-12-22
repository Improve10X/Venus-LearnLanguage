package com.example.learnlanguage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PlayVideoActivity extends BaseActivity {

    private Video video;
    private ImageView imageUrlTxt;
    private ImageView channelLogoUrlTxt;
    private TextView titleTxt;
    private TextView descriptionTxt;
    private TextView channelNameTxt;
    private TextView viewsTxt;
    private TextView uploadTimeTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        getSupportActionBar().setTitle("Play Video");
            video = (Video) getIntent().getSerializableExtra(Constants.KEY_VIDEO);
            setupViews();
            showData();
    }

    private void showData() {
        titleTxt.setText(video.title);
        descriptionTxt.setText(video.description);
        channelNameTxt.setText(video.channelName);
        viewsTxt.setText(video.numberOfViews);
        uploadTimeTxt.setText(video.uploadedTime);
        if(video.imageUrl != null && video.imageUrl.isEmpty() == false) {
            Picasso.get().load(video.imageUrl).into(imageUrlTxt);
        }
        if(video.channelLogoUrl != null && video.channelLogoUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogoUrl).into(channelLogoUrlTxt);
        }
    }

    private void setupViews() {
        imageUrlTxt = findViewById(R.id.image_url_txt);
        channelLogoUrlTxt = findViewById(R.id.channel_logo_url_txt);
        titleTxt = findViewById(R.id.title_txt);
        descriptionTxt = findViewById(R.id.description_txt);
        channelNameTxt = findViewById(R.id.channel_name_txt);
        viewsTxt = findViewById(R.id.views_txt);
        uploadTimeTxt = findViewById(R.id.upload_time_txt);
    }
}