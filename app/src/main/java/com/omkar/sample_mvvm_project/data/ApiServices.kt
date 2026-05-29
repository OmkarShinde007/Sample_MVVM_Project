package com.omkar.sample_mvvm_project.data

import com.omkar.sample_mvvm_project.data.dto.CommentsDTO
import com.omkar.sample_mvvm_project.data.dto.PostsDTO
import com.omkar.sample_mvvm_project.data.dto.UserDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("/users")
    suspend fun fetchUsers(): Response<List<UserDTO>>

    @GET("/comments")
    suspend fun fetchComments(): Response<List<CommentsDTO>>

    @GET("/posts")
    suspend fun fetchPosts(): Response<List<PostsDTO>>
}