package com.app.nasagalleryapp

import android.app.Application
import com.app.nasagalleryapp.di.applicationModule
import com.app.nasagalleryapp.di.repositoryModules
import com.app.nasagalleryapp.di.serviceModules
import com.app.nasagalleryapp.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NasaGalleryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NasaGalleryApplication)
            modules(applicationModule, serviceModules, repositoryModules, viewModelModules)
        }
    }
}