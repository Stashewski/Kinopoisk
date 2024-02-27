package com.uladzislaumak.firstproject.data

import androidx.lifecycle.LiveData
import com.uladzislaumak.firstproject.data.dao.FilmDao
import com.uladzislaumak.firstproject.data.entity.Film
import java.util.concurrent.Executors
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()

}