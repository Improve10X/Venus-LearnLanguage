package com.example.learnlanguage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Video implements Serializable {

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
