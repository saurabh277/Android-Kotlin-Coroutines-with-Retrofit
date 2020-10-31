package com.example.kotlincoroutinewithretrofit.Network

import com.example.kotlincoroutinewithretrofit.Model.Post
import retrofit2.http.GET

interface Api {
    @GET("posts")
    suspend fun getPost():List<Post>
}