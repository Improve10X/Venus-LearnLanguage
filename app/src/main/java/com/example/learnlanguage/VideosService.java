package com.example.learnlanguage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VideosService {

    @GET("videos")
    Call<List<Video>> fetchVideos();

}
