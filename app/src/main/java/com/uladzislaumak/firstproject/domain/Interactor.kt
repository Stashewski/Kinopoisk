package com.uladzislaumak.firstproject.domain

import com.amsdevelops.filmssearch.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}