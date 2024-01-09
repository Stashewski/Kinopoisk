package com.amsdevelops.firstproject.di

import com.amsdevelops.firstproject.di.modules.DatabaseModule
import com.amsdevelops.firstproject.di.modules.DomainModule
import com.amsdevelops.firstproject.di.modules.RemoteModule
import com.amsdevelops.firstproject.viewmodel.HomeFragmentViewModel
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