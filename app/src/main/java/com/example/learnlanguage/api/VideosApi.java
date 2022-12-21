package com.example.learnlanguage.api;

import com.example.learnlanguage.Constants;
import com.example.learnlanguage.api.VideosService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideosApi {

    public VideosService createVideoService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VideosService videosService = retrofit.create(VideosService.class);
        return videosService;
    }
}
