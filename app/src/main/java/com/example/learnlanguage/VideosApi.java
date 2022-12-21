package com.example.learnlanguage;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideosApi {

    VideosService createVideoService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VideosService videosService = retrofit.create(VideosService.class);
        return videosService;
    }
}
