package com.omkar.sample_mvvm_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.omkar.sample_mvvm_project.presenter.DashboardScreen
import com.omkar.sample_mvvm_project.ui.theme.Sample_MVVM_ProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sample_MVVM_ProjectTheme {
                DashboardScreen()
            }
        }
    }
}