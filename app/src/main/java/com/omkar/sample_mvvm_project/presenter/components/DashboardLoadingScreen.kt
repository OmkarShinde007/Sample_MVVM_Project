package com.omkar.sample_mvvm_project.presenter.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.omkar.sample_mvvm_project.ui.theme.Sample_MVVM_ProjectTheme

@Composable
fun DashboardLoadingScreen() {

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@PreviewLightDark
@Composable
private fun DashboardLoadingScreenPreview() {
    Sample_MVVM_ProjectTheme {
        DashboardLoadingScreen()
    }
}