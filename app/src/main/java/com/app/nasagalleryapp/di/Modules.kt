package com.app.nasagalleryapp.di

import com.app.nasagalleryapp.NasaDataRepository
import com.app.nasagalleryapp.data.AssetDataService
import com.app.nasagalleryapp.data.DataService
import com.app.nasagalleryapp.ui.ImageListingViewModel
import com.app.nasagalleryapp.utils.FileUtils
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    //Application Level dependencies goes here
    single {
        FileUtils()
    }
}

val serviceModules = module {
    //Service Layer dependencies goes here
    single<DataService> {
        AssetDataService(get(), get())
    }
}

val repositoryModules = module {
    //Repositories dependencies goes here
    single {
        NasaDataRepository(get())
    }
}

val viewModelModules = module {
    //ViewModels dependencies goes here
    viewModel {
        ImageListingViewModel(get())
    }
}