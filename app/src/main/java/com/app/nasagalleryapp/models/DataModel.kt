package com.app.nasagalleryapp.models

import android.os.Parcelable
import com.app.nasagalleryapp.utils.DateAsStringSerializer
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
@Parcelize
data class DataModel(
    @Transient @SerialName("copyright") val copyRight: String = "",
    @SerialName("date") @Serializable(with = DateAsStringSerializer::class) val date: Date,
    @SerialName("explanation") val explanation: String,
    @SerialName("hdurl") val hdUrl: String,
    @SerialName("media_type") val mediaType: String,
    @SerialName("service_version") val serviceVersion: String,
    @SerialName("title") val title: String,
    @SerialName("url") val url: String,
) : Parcelable
