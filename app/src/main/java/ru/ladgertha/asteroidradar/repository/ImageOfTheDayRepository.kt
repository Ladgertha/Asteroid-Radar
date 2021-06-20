package ru.ladgertha.asteroidradar.repository

import retrofit2.await
import ru.ladgertha.asteroidradar.api.ImageOfTheDay
import ru.ladgertha.asteroidradar.api.service.ImageOfTheDayService
import ru.ladgertha.asteroidradar.mapper.ImageOfTheDayMapper
import ru.ladgertha.asteroidradar.room.AsteroidDatabase
import ru.ladgertha.asteroidradar.utils.DateHelper

class ImageOfTheDayRepository(
    private val apiKey: String,
    private val database: AsteroidDatabase,
    private val networkApiService: ImageOfTheDayService
) {

    suspend fun getSavedImage(): ImageOfTheDay {
        val savedImage = database.imageOfTheDayDao().getImageOfTheDay()
        if (savedImage != null) {
            return ImageOfTheDayMapper.mapFromDatabaseEntity(savedImage)
        }

        return updateImage()
    }

    suspend fun updateImage(): ImageOfTheDay {
        val imageOfTheDayFromApi =
            networkApiService.retrofitService.getImageOfTheDay(apiKey).await()
        database.imageOfTheDayDao()
            .insert(ImageOfTheDayMapper.mapToDatabaseEntity(imageOfTheDayFromApi))
        return imageOfTheDayFromApi
    }

    fun deleteYesterdayImageOfTheDay() {
        database.imageOfTheDayDao().deleteYesterdayImage(DateHelper.getYesterday())
    }

}
