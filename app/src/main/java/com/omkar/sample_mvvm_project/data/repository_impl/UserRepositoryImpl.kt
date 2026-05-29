package com.omkar.sample_mvvm_project.data.repository_impl

import com.omkar.sample_mvvm_project.core.common.ApiResult
import com.omkar.sample_mvvm_project.data.ApiServices
import com.omkar.sample_mvvm_project.data.mapper.userDTOToEntityMapper
import com.omkar.sample_mvvm_project.domain.model.UserEntity
import com.omkar.sample_mvvm_project.domain.repository.UserRepository
import com.omkar.sample_mvvm_project.core.common.Constants.ERROR_MESSAGE_USER
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiServices: ApiServices) :
    UserRepository {

    override suspend fun fetchUsers(): ApiResult<List<UserEntity>> {
        try {
            val response = apiServices.fetchUsers()

            return if (response.isSuccessful) {
                val mappingResult =
                    response.body()?.map { it.userDTOToEntityMapper() } ?: emptyList()
                ApiResult.Success(mappingResult)
            } else {
                ApiResult.Failure(ERROR_MESSAGE_USER)
            }
        } catch (e: Exception) {
            return ApiResult.Failure(e.message ?: ERROR_MESSAGE_USER)
        }

    }
}