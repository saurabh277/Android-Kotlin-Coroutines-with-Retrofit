package com.example.kotlincoroutinewithretrofit.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutinewithretrofit.Model.Post
import com.example.kotlincoroutinewithretrofit.Repository.PostRepository
import kotlinx.coroutines.launch
import java.lang.Exception


//the data to show in ui that is in recyclerView we put that data in viewModel
//so that any time during rotation the data not lost
//we use live data with viewmodel-because if any time data at server changes so live data can
//change it in ui
class PostViewModel(private val postRepository: PostRepository) :ViewModel(){
    val postMutableLiveData:MutableLiveData<List<Post>> = MutableLiveData()
     //the data come in repository we need to fetch it in View Model
    fun getPost(){
         //BY this our data come from background to ui
         viewModelScope.launch {
             try {
                 val response = postRepository.getPost()
                 postMutableLiveData.value = response
             }
             catch (e:Exception){
                 Log.d("main","getPost: ${e.message}")
             }
         }

     }
}