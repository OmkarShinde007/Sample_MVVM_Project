package com.omkar.sample_mvvm_project

import com.omkar.sample_mvvm_project.core.common.ApiResult
import com.omkar.sample_mvvm_project.core.common.Constants.ERROR_MESSAGE_COMMENTS
import com.omkar.sample_mvvm_project.core.common.Constants.ERROR_MESSAGE_POSTS
import com.omkar.sample_mvvm_project.core.common.Constants.ERROR_MESSAGE_USER
import com.omkar.sample_mvvm_project.domain.DashboardUseCases
import com.omkar.sample_mvvm_project.domain.model.CommentsEntity
import com.omkar.sample_mvvm_project.domain.model.PostsEntity
import com.omkar.sample_mvvm_project.domain.model.UserEntity
import com.omkar.sample_mvvm_project.domain.repository.CommentsRepository
import com.omkar.sample_mvvm_project.domain.repository.PostsRepository
import com.omkar.sample_mvvm_project.domain.repository.UserRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class DashboardUseCasesTest {

    lateinit var dashboardUseCases: DashboardUseCases
    val userRepository: UserRepository = mock()
    val commentsRepository: CommentsRepository = mock()
    val postsRepository: PostsRepository = mock()

    val users = listOf(
        UserEntity(
            id = 1,
            name = "Omkar",
            email = "test@email.com",
            userName = "Test",
            phoneNo = "288282382",
            city = "Pune",
            zipCode = "411018"
        ), UserEntity(
            id = 2,
            name = "Omkar",
            email = "test@email.com",
            userName = "Test",
            phoneNo = "288282382",
            city = "Pune",
            zipCode = "411018"
        ), UserEntity(
            id = 3,
            name = "Omkar",
            email = "test@email.com",
            userName = "Test",
            phoneNo = "288282382",
            city = "Pune",
            zipCode = "411018"
        ), UserEntity(
            id = 4,
            name = "Omkar",
            email = "test@email.com",
            userName = "Test",
            phoneNo = "288282382",
            city = "Pune",
            zipCode = "411018"
        ), UserEntity(
            id = 5,
            name = "Omkar",
            email = "test@email.com",
            userName = "Test",
            phoneNo = "288282382",
            city = "Pune",
            zipCode = "411018"
        ), UserEntity(
            id = 6,
            name = "Omkar",
            email = "test@email.com",
            userName = "Test",
            phoneNo = "288282382",
            city = "Pune",
            zipCode = "411018"
        )
    )

    val posts = listOf(
        PostsEntity(
            id = 1, title = "Test Post", posts = "Demo posts"
        ), PostsEntity(
            id = 2, title = "Test Post 2", posts = "Demo posts 2"
        )
    )

    val comments = listOf(
        CommentsEntity(
            id = 1, name = "Omkar", email = "test@email.com", comment = "This is test comment 1"
        ), CommentsEntity(
            id = 2, name = "Shinde", email = "test@email.com", comment = "This is test comment 2"
        )
    )

    @Before
    fun setup() {
        dashboardUseCases = DashboardUseCases(
            userRepository = userRepository,
            commentsRepository = commentsRepository,
            postsRepository = postsRepository
        )
    }

    @Test
    fun test_data_success_scenario() = runTest {
        whenever(userRepository.fetchUsers()).thenReturn(
            ApiResult.Success(
                users
            )
        )

        whenever(postsRepository.fetchPosts()).thenReturn(
            ApiResult.Success(
                posts
            )
        )

        whenever(commentsRepository.fetchComments()).thenReturn(
            ApiResult.Success(
                comments
            )
        )


        val response = dashboardUseCases()

        Assert.assertEquals(users.take(5), response.users)
        Assert.assertEquals(posts, response.posts)
        Assert.assertEquals(comments, response.comments)

    }

    @Test
    fun test_data_failure_scenario() = runTest {
        whenever(userRepository.fetchUsers()).thenReturn(
            ApiResult.Failure(ERROR_MESSAGE_USER)
        )

        whenever(postsRepository.fetchPosts()).thenReturn(
            ApiResult.Failure(ERROR_MESSAGE_POSTS)
        )

        whenever(commentsRepository.fetchComments()).thenReturn(
            ApiResult.Failure(ERROR_MESSAGE_COMMENTS)
        )

        val response = dashboardUseCases()

        Assert.assertEquals(emptyList<UserEntity>(), response.users)
        Assert.assertEquals(ERROR_MESSAGE_USER, response.userError)
        Assert.assertEquals(ERROR_MESSAGE_POSTS, response.postsError)
        Assert.assertEquals(ERROR_MESSAGE_COMMENTS, response.commentsError)

    }
}