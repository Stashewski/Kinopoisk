package com.uladzislaumak.firstproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uladzislaumak.firstproject.data.dao.FilmDao
import com.uladzislaumak.firstproject.data.entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}