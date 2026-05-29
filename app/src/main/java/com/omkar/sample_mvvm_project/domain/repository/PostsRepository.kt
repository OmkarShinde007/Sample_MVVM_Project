package com.omkar.sample_mvvm_project.domain.repository

import com.omkar.sample_mvvm_project.core.common.ApiResult
import com.omkar.sample_mvvm_project.domain.entity.PostsEntity

interface PostsRepository {

    suspend fun fetchPosts() : ApiResult<List<PostsEntity>>
}