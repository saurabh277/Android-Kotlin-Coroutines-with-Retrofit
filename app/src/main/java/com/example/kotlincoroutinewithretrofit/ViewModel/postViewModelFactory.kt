package com.example.kotlincoroutinewithretrofit.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincoroutinewithretrofit.Repository.PostRepository

class postViewModelFactory(private val postRepository: PostRepository) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }

}