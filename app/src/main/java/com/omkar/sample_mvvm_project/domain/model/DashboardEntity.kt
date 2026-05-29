package com.omkar.sample_mvvm_project.domain.model

data class DashboardEntity(
    val users: List<UserEntity> = emptyList(),
    val posts: List<PostsEntity> = emptyList(),
    val comments: List<CommentsEntity> = emptyList(),
    val userError: String? = null,
    val postsError: String? = null,
    val commentsError: String? = null
)
