package com.example.myretrofit.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofit.model.Post
import com.example.myretrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2 : MutableLiveData<Response<Post>> = MutableLiveData()
    val customPosts : MutableLiveData<Response<List<Post>>> = MutableLiveData()


    fun getPost(){
        viewModelScope.launch {
            val response:Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(Number:Int){
        viewModelScope.launch {
            val response:Response<Post> = repository.getPost2(Number)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId:Int,sort:String,order:String){
        viewModelScope.launch {
            val response:Response<List<Post>> = repository.getCustomPost(userId,sort,order)
            customPosts.value = response
        }
    }


}