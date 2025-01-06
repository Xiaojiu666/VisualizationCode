package com.ax.visualizationcode

sealed class UiState {

    data object Loading : UiState()

    data class Successful<T>(val data: T) : UiState()

    data class Fail(val msg: String, val code: Int) : UiState()
}