package com.example.learnlanguage;

import android.os.Bundle;

public class PlayVideoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        getSupportActionBar().setTitle("Play Video");
    }
}