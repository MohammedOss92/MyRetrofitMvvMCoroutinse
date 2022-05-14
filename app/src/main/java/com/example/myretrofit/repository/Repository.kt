package com.example.myretrofit.repository

import com.example.myretrofit.api.RetrofitInstance
import com.example.myretrofit.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost():Response<Post>{
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(Number:Int):Response<Post>{
        return RetrofitInstance.api.getPosts2(Number)
    }

    suspend fun getCustomPost(userId:Int,sort:String,order:String):Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost(userId,sort,order)
    }


}