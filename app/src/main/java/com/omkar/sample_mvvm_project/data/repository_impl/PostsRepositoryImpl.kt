package com.omkar.sample_mvvm_project.data.repository_impl

import com.omkar.sample_mvvm_project.core.common.ApiResult
import com.omkar.sample_mvvm_project.data.api.ApiServices
import com.omkar.sample_mvvm_project.data.mapper.postsDTOToEntityMapper
import com.omkar.sample_mvvm_project.domain.model.PostsEntity
import com.omkar.sample_mvvm_project.domain.repository.PostsRepository
import com.omkar.sample_mvvm_project.core.common.Constants.ERROR_MESSAGE_POSTS
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(private val apiServices: ApiServices) :
    PostsRepository {

    override suspend fun fetchPosts(): ApiResult<List<PostsEntity>> {
        try {
            val response = apiServices.fetchPosts()
            return if (response.isSuccessful) {
                val mappedResult =
                    response.body()?.map { it.postsDTOToEntityMapper() } ?: emptyList()
                ApiResult.Success(mappedResult)
            } else {
                ApiResult.Failure(ERROR_MESSAGE_POSTS)
            }
        } catch (e: Exception) {
            return ApiResult.Failure(e.message ?: ERROR_MESSAGE_POSTS)
        }

    }
}