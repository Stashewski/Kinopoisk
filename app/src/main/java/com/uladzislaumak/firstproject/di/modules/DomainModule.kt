package com.uladzislaumak.firstproject.di.modules


import android.content.Context
import com.uladzislaumak.firstproject.App
import com.uladzislaumak.firstproject.data.MainRepository
import com.uladzislaumak.firstproject.data.TmdbApi
import com.uladzislaumak.firstproject.data.preferenes.PreferenceProvider
import com.uladzislaumak.firstproject.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
//Передаем контекст для SharedPreferences через конструктор
class DomainModule(val context: Context) {
    //Нам нужно контекст как-то провайдить, поэтому создаем такой метод
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    //Создаем экземпляр SharedPreferences
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) = Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}