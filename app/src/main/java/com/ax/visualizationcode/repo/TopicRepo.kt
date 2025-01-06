package com.ax.visualizationcode.repo

import com.ax.visualizationcode.data.room.dao.TopicDao
import com.ax.visualizationcode.data.room.entity.TopicEntity
import javax.inject.Inject

class TopicRepo @Inject constructor(private val topicDao: TopicDao) {


    suspend fun getTopicList() = topicDao.getAllTopic()

    suspend fun insertTopic(topicEntity: TopicEntity) = topicDao.insert(topicEntity)

}