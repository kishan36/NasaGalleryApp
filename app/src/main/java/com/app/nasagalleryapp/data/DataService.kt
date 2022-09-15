package com.app.nasagalleryapp.data

import com.app.nasagalleryapp.models.DataModel
import com.app.nasagalleryapp.utils.Result
interface DataService {
    suspend fun getImages(): Result<List<DataModel>>
}