package com.uladzislaumak.firstproject.utils

import com.uladzislaumak.firstproject.data.entity.TmdbFilm
import com.uladzislaumak.firstproject.data.entity.Film

object Converter {
    fun convertApiListToDTOList(list: List<TmdbFilm>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(Film(
                title = it.title,
                poster = it.posterPath,
                description = it.overview,
                rating = it.voteAverage,
                isInFavorites = false
            ))
        }
        return result
    }
}