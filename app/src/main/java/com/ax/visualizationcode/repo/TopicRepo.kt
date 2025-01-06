package com.ax.visualizationcode.repo

import com.ax.visualizationcode.data.room.dao.TopicDao
import javax.inject.Inject

class TopicRepo @Inject constructor(private val topicDao: TopicDao) {


    suspend fun getTopicList() = topicDao.getAllTopic()

}