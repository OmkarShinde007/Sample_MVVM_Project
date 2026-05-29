package com.omkar.sample_mvvm_project.presenter.components

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
import com.omkar.sample_mvvm_project.core.common.Constants.COMMON_ERROR
import com.omkar.sample_mvvm_project.ui.theme.Sample_MVVM_ProjectTheme

@Composable
fun ErrorCard(
    message: String
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFEBEE)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {

        Text(
            text = message,
            modifier = Modifier.padding(16.dp),
            color = Color.Red,
            fontWeight = FontWeight.Medium
        )
    }
}

@PreviewLightDark
@Composable
private fun ErrorCardPreview()
{
    Sample_MVVM_ProjectTheme {
        ErrorCard(COMMON_ERROR)
    }
}