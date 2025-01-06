package com.ax.visualizationcode.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ax.visualizationcode.data.room.TABLE_NAME_TOPIC


@Entity(tableName = "topic")
data class TopicEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val content: String,
    val createTime: Long
)