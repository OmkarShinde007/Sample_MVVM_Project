package com.omkar.sample_mvvm_project.domain.repository

import com.omkar.sample_mvvm_project.core.common.ApiResult
import com.omkar.sample_mvvm_project.domain.model.UserEntity

interface UserRepository {

    suspend fun fetchUsers() : ApiResult<List<UserEntity>>
}