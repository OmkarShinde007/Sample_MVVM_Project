package com.omkar.sample_mvvm_project.data.repository_impl

import com.omkar.sample_mvvm_project.core.common.ApiResult
import com.omkar.sample_mvvm_project.data.ApiServices
import com.omkar.sample_mvvm_project.data.mapper.commentDTOToEntityMapper
import com.omkar.sample_mvvm_project.domain.model.CommentsEntity
import com.omkar.sample_mvvm_project.domain.repository.CommentsRepository
import com.omkar.sample_mvvm_project.core.common.Constants.ERROR_MESSAGE_COMMENTS
import javax.inject.Inject

class CommentsRepositoryImpl @Inject constructor(private val apiServices: ApiServices) :
    CommentsRepository {

    override suspend fun fetchComments(): ApiResult<List<CommentsEntity>> {

        try {
            val response = apiServices.fetchComments()

            return if (response.isSuccessful) {
                ApiResult.Success(response.body()?.map { it.commentDTOToEntityMapper() }
                    ?: emptyList())
            } else {
                ApiResult.Failure(ERROR_MESSAGE_COMMENTS)
            }
        } catch (e: Exception) {
            return ApiResult.Failure(e.message ?: ERROR_MESSAGE_COMMENTS)
        }

    }
}