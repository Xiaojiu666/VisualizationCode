package com.ax.visualizationcode.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ax.visualizationcode.data.room.TABLE_NAME_TOPIC
import com.ax.visualizationcode.data.room.entity.TopicEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TopicDao {

    @Insert
    fun insert(user: TopicEntity)

    @Query("SELECT * FROM $TABLE_NAME_TOPIC")
    fun getAllTopic(): Flow<List<TopicEntity>>

//    @Query("SELECT * FROM $TABLE_NAME_TOPIC WHERE id = :userId")
//    suspend fun getTopicById(userId: Int): TopicEntity?
//
//    @Query("SELECT * FROM $TABLE_NAME_TOPIC WHERE content = :content")
//    suspend fun getDiaryByTitle(content: String): TopicEntity?
//
//    @Query("UPDATE $TABLE_NAME_TOPIC SET content = :newName WHERE id = :userId")
//    suspend fun updateName(userId: Int, newName: String)
//
//    @Query("DELETE FROM $TABLE_NAME_TOPIC WHERE id = :userId")
//    suspend fun deleteUser(userId: Int)

}