package com.uladzislaumak.firstproject.di

import com.uladzislaumak.firstproject.di.modules.DatabaseModule
import com.uladzislaumak.firstproject.di.modules.DomainModule
import com.uladzislaumak.firstproject.di.modules.RemoteModule
import com.uladzislaumak.firstproject.viewmodel.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
}