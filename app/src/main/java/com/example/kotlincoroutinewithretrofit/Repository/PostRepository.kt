package com.example.kotlincoroutinewithretrofit.Repository

import com.example.kotlincoroutinewithretrofit.Model.Post
import com.example.kotlincoroutinewithretrofit.Network.RetrofitBuilder
import com.example.kotlincoroutinewithretrofit.R

class PostRepository {
    suspend fun getPost():List<Post> = RetrofitBuilder.api.getPost()

}