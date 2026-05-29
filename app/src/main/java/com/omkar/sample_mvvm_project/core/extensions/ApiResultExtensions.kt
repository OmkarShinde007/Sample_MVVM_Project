package com.omkar.sample_mvvm_project.core.extensions

import com.omkar.sample_mvvm_project.core.common.ApiResult

fun <T> ApiResult<T>.getDataOrNull(): T? {
    return when (this) {
        is ApiResult.Success -> data
        is ApiResult.Failure -> null
    }
}

fun <T> ApiResult<T>.getErrorOrNull(): String? {
    return when (this) {
        is ApiResult.Failure -> message
        else -> null
    }
}