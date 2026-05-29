package com.omkar.sample_mvvm_project.presenter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkar.sample_mvvm_project.domain.entity.CommentsEntity
import com.omkar.sample_mvvm_project.ui.theme.Sample_MVVM_ProjectTheme

@Composable
fun DashboardSection(
    title: String, error: String?, itemCount: Int, content: @Composable () -> Unit
) {

    Column {

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = title, fontSize = 22.sp, fontWeight = FontWeight.Bold
            )

            Text(
                text = "$itemCount Items", color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (error != null) {

            ErrorCard(error)

        } else {

            content()
        }
    }
}

@PreviewLightDark
@Composable
private fun DashboardSectionPreview() {
    Sample_MVVM_ProjectTheme {
        DashboardSection(
            title = "Users", itemCount = 2, error = null
        ) {
            Column {
                CommentCard(
                    comment = CommentsEntity(
                        id = 1, name = "Omkar", email = "test@email.com", comment = "This is test comment"
                    )
                )
            }
        }
    }
}