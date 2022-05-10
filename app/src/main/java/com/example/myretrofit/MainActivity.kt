package com.example.myretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myretrofit.ViewModel.MainViewModel
import com.example.myretrofit.ViewModel.MainViewModelFactory
import com.example.myretrofit.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    lateinit var aa:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        aa=findViewById(R.id.aa)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->

            if(response.isSuccessful){
                aa.text = response.body()?.title!!
                Log.d("Response",response.body()?.userId.toString())
                Log.d("Response",response.body()?.id.toString())
                Log.d("Response",response.body()?.title!!)
                Log.d("Response",response.body()?.body!!)
            }else{
                Log.d("Response",response.errorBody().toString())
                aa.text = response.code().toString()
            }

        })
    }
}