package com.uladzislaumak.firstproject;

import android.app.Application
import com.uladzislaumak.firstproject.di.AppComponent
import com.uladzislaumak.firstproject.di.DaggerAppComponent
import com.uladzislaumak.firstproject.di.modules.DatabaseModule
import com.uladzislaumak.firstproject.di.modules.DomainModule
import com.uladzislaumak.firstproject.di.modules.RemoteModule

class App : Application() {
        lateinit var dagger: AppComponent

        override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
        .remoteModule(RemoteModule())
        .databaseModule(DatabaseModule())
        .domainModule(DomainModule(this))
        .build()
        }

        companion object {
        lateinit var instance: App
private set
        }
        }