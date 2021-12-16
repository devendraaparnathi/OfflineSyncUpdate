package com.example.offlinesyncupdate;

import com.example.offlinesyncupdate.Api.Comment;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RestApiService {

    @POST("posts")
    Call<Comment>postComment(@Body Comment comment);

}
