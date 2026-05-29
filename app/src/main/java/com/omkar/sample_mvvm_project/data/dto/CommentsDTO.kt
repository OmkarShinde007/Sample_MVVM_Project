package com.omkar.sample_mvvm_project.data.dto

data class CommentsDTO(
    val postId : Int,
    val id : Int,
    val name: String,
    val email : String,
    val body : String
)
