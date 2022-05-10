package com.example.myretrofit.api

import com.example.myretrofit.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost() : Response<Post>


}