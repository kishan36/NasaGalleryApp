package com.app.nasagalleryapp.data

import android.content.Context
import com.app.nasagalleryapp.models.DataModel
import com.app.nasagalleryapp.utils.FileUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString

import kotlinx.serialization.json.Json
import com.app.nasagalleryapp.utils.Result
class AssetDataService(private val context: Context, private val fileUtils: FileUtils) :
    DataService {
    override suspend fun getImages(): Result<List<DataModel>> {
        try {
            return withContext(Dispatchers.IO) {
                val imagesJsonString = fileUtils.loadDataFromAsset(context, "data.json")
                    ?: return@withContext Result.Error(Exception("Images Not Found"))
                val imageList = Json.decodeFromString<List<DataModel>>(
                    imagesJsonString
                )
                return@withContext Result.Success(imageList)
            }
        } catch (ex: Exception) {
            return Result.Error(ex)
        }
    }
}