package com.omkar.sample_mvvm_project.domain

import com.omkar.sample_mvvm_project.core.getDataOrNull
import com.omkar.sample_mvvm_project.core.getErrorOrNull
import com.omkar.sample_mvvm_project.domain.entity.DashboardEntity
import com.omkar.sample_mvvm_project.domain.repository.CommentsRepository
import com.omkar.sample_mvvm_project.domain.repository.PostsRepository
import com.omkar.sample_mvvm_project.domain.repository.UserRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

class DashboardUseCases @Inject constructor(
    private val userRepository: UserRepository,
    private val commentsRepository: CommentsRepository,
    private val postsRepository: PostsRepository,
) {

    suspend operator fun invoke(): DashboardEntity {

        return supervisorScope {
            val users = async { userRepository.fetchUsers() }
            val posts = async { postsRepository.fetchPosts() }
            val comments = async { commentsRepository.fetchComments() }

            val userResult = users.await()
            val postsResult = posts.await()
            val commentsResult = comments.await()


            DashboardEntity(
                users = userResult.getDataOrNull()?.take(10) ?: emptyList(),

                posts = postsResult.getDataOrNull()?.take(10) ?: emptyList(),

                comments = commentsResult.getDataOrNull()?.take(10) ?: emptyList(),

                userError = userResult.getErrorOrNull(),

                postsError = postsResult.getErrorOrNull(),

                commentsError = commentsResult.getErrorOrNull()
            )
        }
    }
}