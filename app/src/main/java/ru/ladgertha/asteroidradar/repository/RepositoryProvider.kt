package ru.ladgertha.asteroidradar.repository

import android.content.Context
import ru.ladgertha.asteroidradar.BuildConfig
import ru.ladgertha.asteroidradar.api.service.ApiServiceProvider
import ru.ladgertha.asteroidradar.room.AsteroidDatabase

class RepositoryProvider {
    private var asteroidRepository: AsteroidRepository? = null
    private var imageOfTheDayRepository: ImageOfTheDayRepository? = null
    private var database: AsteroidDatabase? = null
    private val apiServiceProvider by lazy {
        ApiServiceProvider()
    }

    fun getAsteroidRepository(context: Context): AsteroidRepository {
        if (asteroidRepository != null) return asteroidRepository as AsteroidRepository

        asteroidRepository = AsteroidRepository(
            BuildConfig.NASA_API_KEY,
            getDatabase(context),
            apiServiceProvider.getAsteroidServiceProvider()
        )
        return asteroidRepository as AsteroidRepository
    }

    fun getImageOfTheDayRepository(context: Context): ImageOfTheDayRepository {
        if (imageOfTheDayRepository != null) return imageOfTheDayRepository as ImageOfTheDayRepository

        imageOfTheDayRepository = ImageOfTheDayRepository(
            BuildConfig.NASA_API_KEY,
            getDatabase(context),
            apiServiceProvider.getImageOfTheDayService()
        )
        return imageOfTheDayRepository as ImageOfTheDayRepository
    }

    private fun getDatabase(context: Context): AsteroidDatabase {
        if (database != null) database

        database = AsteroidDatabase.getDatabase(context)
        return database as AsteroidDatabase
    }
}