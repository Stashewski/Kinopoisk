package com.uladzislaumak.remote_module;

import com.uladzislaumak.firstproject.data.Entity.TmdbResults
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.uladzislaumak.remote_module.entity.TmdbResults

interface TmdbApi {
    @GET("3/movie/{category}")
    fun getFilms(
            @Path("category") category: String,
            @Query("api_key") apiKey: String,
            @Query("language") language: String,
            @Query("page") page: Int
    ): Call<TmdbResults>

    @GET("3/search/movie")
    fun getFilmFromSearch(
            @Query("api_key") apiKey: String,
            @Query("language") language: String,
            @Query("query") query: String,
            @Query("page") page: Int
    ): Observable<TmdbResults>
}