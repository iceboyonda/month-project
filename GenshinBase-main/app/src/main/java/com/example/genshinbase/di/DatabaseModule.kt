package com.example.genshinbase.di

import android.content.Context
import androidx.room.Room
import com.example.genshinbase.data.local.AppDatabase
import com.example.genshinbase.data.local.repository.GenshinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "genshin_db"
        ).build()
    }

    @Provides
    fun provideRaceDriverCrossRefDao(database: AppDatabase): GenshinRepository {
        return database.genshinDao()
    }

}