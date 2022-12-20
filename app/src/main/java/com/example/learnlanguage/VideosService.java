package com.example.learnlanguage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface VideosService {

    @GET("videos")
    Call<List<Video>> fetchVideos();

    @POST("videos")
    Call<Video> createVideo(@Body Video video);

}
