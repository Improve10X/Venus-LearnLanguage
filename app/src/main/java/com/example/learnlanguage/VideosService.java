package com.example.learnlanguage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VideosService {

    @GET("videos")
    Call<List<Video>> fetchVideos();

    @POST("videos")
    Call<Video> createVideo(@Body Video video);

    @DELETE("videos/{id}")
    Call<Void> deleteVideo(@Path("id")String id);

}
