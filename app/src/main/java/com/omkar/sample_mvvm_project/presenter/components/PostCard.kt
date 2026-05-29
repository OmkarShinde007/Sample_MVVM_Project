package com.omkar.sample_mvvm_project.presenter.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkar.sample_mvvm_project.domain.model.PostsEntity
import com.omkar.sample_mvvm_project.ui.theme.Sample_MVVM_ProjectTheme

@Composable
fun PostCard(
    post: PostsEntity
) {

    Card(
        shape = RoundedCornerShape(20.dp), elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = post.title, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = post.posts, color = Color.DarkGray
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun PostCardPreview() {
    Sample_MVVM_ProjectTheme {
        PostCard(
            post = PostsEntity(
                id = 1, title = "Test Post", posts = "Demo posts"
            )
        )
    }
}