package com.omkar.sample_mvvm_project.domain.repository

import com.omkar.sample_mvvm_project.core.common.ApiResult
import com.omkar.sample_mvvm_project.domain.model.CommentsEntity

interface CommentsRepository {
    suspend fun fetchComments(): ApiResult<List<CommentsEntity>>
}