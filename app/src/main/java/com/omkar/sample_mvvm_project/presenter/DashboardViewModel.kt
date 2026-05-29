package com.omkar.sample_mvvm_project.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omkar.sample_mvvm_project.core.common.Constants.COMMON_ERROR
import com.omkar.sample_mvvm_project.domain.DashboardUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(val dashboardUseCases: DashboardUseCases) :
    ViewModel() {

    private val _dashboardState = MutableStateFlow<DashboardState>(DashboardState.Loading)
    val dashboardState = _dashboardState.asStateFlow()

    init {
        fetchUsers()
    }

    private fun fetchUsers() = viewModelScope.launch(Dispatchers.IO) {
        val response = dashboardUseCases()
        if (response.users.isNotEmpty()) {
            _dashboardState.update { DashboardState.Success(response) }
        } else {
            _dashboardState.update {
                DashboardState.Failure(
                    errorMessage = response.userError ?: COMMON_ERROR
                )
            }
        }
    }
}