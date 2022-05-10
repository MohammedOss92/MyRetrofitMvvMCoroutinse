package com.example.myretrofit.repository

import com.example.myretrofit.api.RetrofitInstance
import com.example.myretrofit.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost():Response<Post>{
        return RetrofitInstance.api.getPost()
    }
}