package com.omkar.sample_mvvm_project.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.omkar.sample_mvvm_project.domain.entity.CommentsEntity
import com.omkar.sample_mvvm_project.domain.entity.DashboardEntity
import com.omkar.sample_mvvm_project.domain.entity.PostsEntity
import com.omkar.sample_mvvm_project.domain.entity.UserEntity
import com.omkar.sample_mvvm_project.presenter.components.CommentCard
import com.omkar.sample_mvvm_project.presenter.components.DashboardLoadingScreen
import com.omkar.sample_mvvm_project.presenter.components.DashboardSection
import com.omkar.sample_mvvm_project.presenter.components.FullScreenError
import com.omkar.sample_mvvm_project.presenter.components.PostCard
import com.omkar.sample_mvvm_project.presenter.components.UserCard
import com.omkar.sample_mvvm_project.ui.theme.Sample_MVVM_ProjectTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(viewModel: DashboardViewmodel = hiltViewModel()) {

    val dashboardState by viewModel.dashboardState.collectAsStateWithLifecycle()

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "Dashboard") })
    }) { paddingValues ->

        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            when (val state = dashboardState) {

                is DashboardState.Loading -> {
                    DashboardLoadingScreen()
                }

                is DashboardState.Success -> {

                    DashboardContent(
                        dashboardData = state.data
                    )
                }

                is DashboardState.Failure -> {

                    FullScreenError(
                        message = state.errorMessage
                    )
                }
            }
        }
    }
}

@Composable
private fun DashboardContent(
    dashboardData: DashboardEntity
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {


        item {

            DashboardSection(
                title = "Users",
                error = dashboardData.userError,
                itemCount = dashboardData.users.size
            ) {

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(dashboardData.users) { user ->

                        UserCard(user)
                    }
                }
            }
        }

        item {

            DashboardSection(
                title = "Posts",
                error = dashboardData.postsError,
                itemCount = dashboardData.posts.size
            ) {

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    dashboardData.posts.forEach { post ->

                        PostCard(post)
                    }
                }
            }
        }

        item {

            DashboardSection(
                title = "Comments",
                error = dashboardData.commentsError,
                itemCount = dashboardData.comments.size
            ) {

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    dashboardData.comments.forEach { comment ->

                        CommentCard(comment)
                    }
                }
            }
        }
    }
}

@Composable
@PreviewLightDark
private fun DashboardContentPreview() {
    Sample_MVVM_ProjectTheme {
        DashboardContent(
            dashboardData = DashboardEntity(
                users = listOf(
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
                        name = "Shinde",
                        email = "test@email.com",
                        userName = "Test",
                        phoneNo = "288282382",
                        city = "Pune",
                        zipCode = "411018"
                    )
                ), posts = listOf(
                    PostsEntity(
                        id = 1, title = "Test Post", posts = "Demo posts"
                    ), PostsEntity(
                        id = 2, title = "Test Post 2", posts = "Demo posts"
                    )
                ), comments = listOf(
                    CommentsEntity(
                        id = 1,
                        name = "Omkar",
                        email = "test@email.com",
                        comment = "This is test comment"
                    ), CommentsEntity(
                        id = 2,
                        name = "Shinde",
                        email = "test@email.com",
                        comment = "This is test comment 2"
                    )
                )
            )

        )
    }
}