package com.omkar.sample_mvvm_project.presenter

import com.omkar.sample_mvvm_project.domain.entity.DashboardEntity

sealed class DashboardState {
    object Loading : DashboardState()
    data class Success(val data: DashboardEntity) : DashboardState()
    data class Failure(val errorMessage: String) : DashboardState()
}