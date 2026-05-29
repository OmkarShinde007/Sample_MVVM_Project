package com.omkar.sample_mvvm_project.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import com.omkar.sample_mvvm_project.domain.model.UserEntity
import com.omkar.sample_mvvm_project.ui.theme.Sample_MVVM_ProjectTheme

@Composable
fun UserCard(
    user: UserEntity
) {

    Card(
        modifier = Modifier.width(220.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = user.name.first().toString(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = user.name, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = user.email, color = Color.Gray
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun UserCardPreview() {
    Sample_MVVM_ProjectTheme {
        UserCard(
            user = UserEntity(
                id = 1,
                name = "Omkar",
                email = "test@email.com",
                userName = "Test",
                phoneNo = "288282382",
                city = "Pune",
                zipCode = "411018"
            )
        )
    }

}