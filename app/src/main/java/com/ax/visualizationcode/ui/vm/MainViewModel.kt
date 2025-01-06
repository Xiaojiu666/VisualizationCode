package com.ax.visualizationcode.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ax.visualizationcode.UiState
import com.ax.visualizationcode.data.room.entity.TopicEntity
import com.ax.visualizationcode.repo.TopicRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val topicRepo: TopicRepo) : ViewModel() {

    private val _topicState = MutableStateFlow<UiState>(UiState.Loading)
    val topicState = _topicState.asStateFlow()


    fun getTopicList() {
        viewModelScope.launch(Dispatchers.IO) {
            println("MainViewModel ${Thread.currentThread().name}")
            topicRepo.getTopicList().collect {
                _topicState.emit(UiState.Successful(TopicState(topicList = it)))
            }
        }
    }

    data class TopicState(val topicList: List<TopicEntity>? = null)

}