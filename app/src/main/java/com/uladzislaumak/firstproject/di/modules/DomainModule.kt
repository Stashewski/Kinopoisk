package com.amsdevelops.firstproject.di.modules


import android.content.Context
import com.amsdevelops.firstproject.App
import com.amsdevelops.firstproject.data.MainRepository
import com.amsdevelops.firstproject.data.TmdbApi
import com.amsdevelops.firstproject.data.preferenes.PreferenceProvider
import com.amsdevelops.firstproject.domain.Interactor
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