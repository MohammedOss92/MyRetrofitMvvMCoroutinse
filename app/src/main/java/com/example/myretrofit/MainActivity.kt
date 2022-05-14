package com.example.myretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myretrofit.ViewModel.MainViewModel
import com.example.myretrofit.ViewModel.MainViewModelFactory
import com.example.myretrofit.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    lateinit var aa:TextView
    lateinit var button: Button
    lateinit var ed: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        aa=findViewById(R.id.aa)
        button=findViewById(R.id.button)
        ed=findViewById(R.id.ed)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
//        viewModel.getPost2()
//        viewModel.getPost()
//        viewModel.myResponse.observe(this, Observer { response ->
//        viewModel.myResponse2.observe(this, Observer { response ->
//
//            if(response.isSuccessful){
//                aa.text = response.body()?.title!!
//                Log.d("Response",response.body()?.userId.toString())
//                Log.d("Response",response.body()?.id.toString())
//                Log.d("Response",response.body()?.title!!)
//                Log.d("Response",response.body()?.body!!)
//            }else{
//                Log.d("Response",response.errorBody().toString())
//                aa.text = response.code().toString()
//            }
//
//        })

        button.setOnClickListener {
            val myNumber = ed.text.toString()
//            viewModel.getPost2(Integer.parseInt(myNumber))
            viewModel.getCustomPosts(Integer.parseInt(myNumber),"id","desc")
//            viewModel.myResponse2.observe(this, Observer { response ->
            viewModel.customPosts.observe(this, Observer { response ->

                if(response.isSuccessful){
//                    aa.text = response.body()?.title!!
                    aa.text = response.body().toString()
                    response.body()?.forEach {
                        Log.d("a1a",it.userId.toString())
                        Log.d("a1a",it.id.toString())
                        Log.d("a1a",it.body)
                        Log.d("a1a",it.title)
                    }
                }else{
                    Log.d("Response",response.errorBody().toString())
                    aa.text = response.code().toString()
                }

            })
        }
    }
}