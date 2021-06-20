package ru.ladgertha.asteroidradar.api

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageOfTheDay(
    @Json(name = "media_type")
    val mediaType: String,
    val title: String,
    val url: String
) : Parcelable