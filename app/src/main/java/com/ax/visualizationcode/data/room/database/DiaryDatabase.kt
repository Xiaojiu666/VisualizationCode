package com.ax.visualizationcode.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ax.visualizationcode.data.room.dao.TopicDao
import com.ax.visualizationcode.data.room.entity.TopicEntity


@Database(
    entities = [TopicEntity::class], version = 1,    // 设置exportSchema为false，关闭架构导出功能
    exportSchema = false
)
abstract class DiaryDatabase : RoomDatabase() {

    abstract fun topicDao(): TopicDao

}