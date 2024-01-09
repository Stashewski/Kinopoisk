package com.amsdevelops.firstproject.di.modules

import com.amsdevelops.firstproject.data.MainRepository
import com.amsdevelops.firstproject.data.TmdbApi
import com.amsdevelops.firstproject.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}