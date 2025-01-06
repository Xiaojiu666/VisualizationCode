package com.ax.visualizationcode.di

import android.adservices.topics.Topic
import android.content.Context
import androidx.room.Room
import com.ax.visualizationcode.data.room.dao.TopicDao
import com.ax.visualizationcode.data.room.database.DiaryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DiaryDataModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): DiaryDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            DiaryDatabase::class.java,
            "visualization"
        ).build()

    }

    @Provides
    fun provideDiaryDao(appDatabase: DiaryDatabase): TopicDao {
        return appDatabase.topicDao()
    }
}
