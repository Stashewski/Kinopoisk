package com.uladzislaumak.firstproject.di.modules

import android.content.Context
import com.uladzislaumak.firstproject.data.MainRepository
import com.uladzislaumak.firstproject.data.db.DatabaseHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseHelper(context: Context) = DatabaseHelper(context)

    @Provides
    @Singleton
    fun provideRepository(databaseHelper: DatabaseHelper) = MainRepository(databaseHelper)
}
