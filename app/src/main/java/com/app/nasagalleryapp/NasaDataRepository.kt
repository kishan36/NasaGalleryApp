package com.app.nasagalleryapp

import com.app.nasagalleryapp.data.DataService
import com.app.nasagalleryapp.models.DataModel
import com.app.nasagalleryapp.utils.Result
class NasaDataRepository(private val imagesService: DataService) {
    suspend fun getImages(): Result<List<DataModel>> = imagesService.getImages()
}