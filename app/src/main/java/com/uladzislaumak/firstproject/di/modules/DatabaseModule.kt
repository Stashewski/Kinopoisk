package com.uladzislaumak.firstproject.di.modules

import android.content.Context
import com.uladzislaumak.firstproject.data.MainRepository
import androidx.room.Room
import com.uladzislaumak.firstproject.data.dao.FilmDao
import com.auladzislaumak.firstproject.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFilmDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "film_db"
        ).build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}