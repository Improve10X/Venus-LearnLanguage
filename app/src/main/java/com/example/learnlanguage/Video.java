package com.example.learnlanguage;

import com.google.gson.annotations.SerializedName;

public class Video {

@SerializedName("_id")
    String id;
    String title;
    String description;
    String uploadedTime;
    String numberOfViews;
    String channelName;
    String channelLogoUrl;
    String imageUrl;
}
