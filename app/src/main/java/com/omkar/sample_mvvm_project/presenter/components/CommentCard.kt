package com.omkar.sample_mvvm_project.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkar.sample_mvvm_project.domain.model.CommentsEntity
import com.omkar.sample_mvvm_project.ui.theme.Sample_MVVM_ProjectTheme

@Composable
fun CommentCard(
    comment: CommentsEntity
) {

    Card(
        shape = RoundedCornerShape(18.dp), colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF4CAF50)),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = comment.name.first().toString(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {

                    Text(
                        text = comment.name, fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = comment.email, fontSize = 12.sp, color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = comment.comment
            )
        }
    }
}

@Composable
@PreviewLightDark
private fun CommentCardPreview() {
    Sample_MVVM_ProjectTheme {
        CommentCard(
            comment = CommentsEntity(
                id = 1, name = "Omkar", email = "test@email.com", comment = "This is test comment"
            )
        )
    }
}