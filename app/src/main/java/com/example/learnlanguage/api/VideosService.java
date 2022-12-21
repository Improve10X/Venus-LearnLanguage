package com.example.learnlanguage.api;

import com.example.learnlanguage.Constants;
import com.example.learnlanguage.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface VideosService {

    @GET(Constants.VIDEOS_END_POINT)
    Call<List<Video>> fetchVideos();

    @POST(Constants.VIDEOS_END_POINT)
    Call<Video> createVideo(@Body Video video);

    @DELETE(Constants.VIDEOS_END_POINT + "/{id}")
    Call<Void> deleteVideo(@Path("id") String id);

    @PUT(Constants.VIDEOS_END_POINT + "/{id}")
    Call<Void> updateVideo(@Path("id") String id, @Body Video video);
}
