package com.core.common.util

sealed class Response <out T> {
    data class Success<out T>(val data : T? = null) : Response<T>()
    data class Error(val errorMessage : String? = null) : Response<Nothing>()
    data object Loading : Response<Nothing>()
}