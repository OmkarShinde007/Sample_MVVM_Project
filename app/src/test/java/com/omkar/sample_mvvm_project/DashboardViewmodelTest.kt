package com.omkar.sample_mvvm_project

import app.cash.turbine.test
import com.omkar.sample_mvvm_project.core.common.Constants.ERROR_MESSAGE_COMMENTS
import com.omkar.sample_mvvm_project.core.common.Constants.ERROR_MESSAGE_POSTS
import com.omkar.sample_mvvm_project.core.common.Constants.ERROR_MESSAGE_USER
import com.omkar.sample_mvvm_project.domain.DashboardUseCases
import com.omkar.sample_mvvm_project.domain.entity.CommentsEntity
import com.omkar.sample_mvvm_project.domain.entity.DashboardEntity
import com.omkar.sample_mvvm_project.domain.entity.PostsEntity
import com.omkar.sample_mvvm_project.domain.entity.UserEntity
import com.omkar.sample_mvvm_project.presenter.DashboardState
import com.omkar.sample_mvvm_project.presenter.DashboardViewmodel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewmodelTest {

    lateinit var dashboardViewmodel: DashboardViewmodel
    val dashboardUseCases: DashboardUseCases = mock()

    val users = listOf(
        UserEntity(
            id = 1,
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

    @Test
    fun dashboardState_shouldEmitSuccess_whenUseCaseReturnsData() = runTest {

        val expectedResult = DashboardEntity(
            users = users, posts = posts, comments = comments
        )

        whenever(dashboardUseCases()).thenReturn(
            expectedResult
        )

        dashboardViewmodel = DashboardViewmodel(dashboardUseCases)
        advanceUntilIdle()
        dashboardViewmodel.dashboardState.test {
            val result = awaitItem()
            Assert.assertEquals(DashboardState.Success(expectedResult), result)
        }
    }

    @Test
    fun dashboardState_shouldEmitFailure_whenUseCaseReturnsErrorData() = runTest {

        val expectedResult = DashboardEntity(
            userError = ERROR_MESSAGE_USER,
            commentsError = ERROR_MESSAGE_COMMENTS,
            postsError = ERROR_MESSAGE_POSTS
        )

        whenever(dashboardUseCases()).thenReturn(
            expectedResult
        )

        dashboardViewmodel = DashboardViewmodel(dashboardUseCases)
        advanceUntilIdle()
        dashboardViewmodel.dashboardState.test {
            val result = awaitItem()
            Assert.assertEquals(DashboardState.Failure(ERROR_MESSAGE_USER), result)
        }
    }

    @Test
    fun dashboardState_shouldEmitSuccess_whenUseCaseReturnsErrorData_forPostsAndComments() =
        runTest {

            val expectedResult = DashboardEntity(
                users = users,
                commentsError = ERROR_MESSAGE_COMMENTS,
                postsError = ERROR_MESSAGE_POSTS
            )

            whenever(dashboardUseCases()).thenReturn(
                expectedResult
            )

            dashboardViewmodel = DashboardViewmodel(dashboardUseCases)
            advanceUntilIdle()
            dashboardViewmodel.dashboardState.test {
                val result = awaitItem()
                Assert.assertEquals(DashboardState.Success(expectedResult), result)
            }
        }

}