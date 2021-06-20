package ru.ladgertha.asteroidradar.api.service

class ApiServiceProvider {

    private var asteroidServiceProvider: AsteroidApiService? = null
    private var imageOfTheDayService: ImageOfTheDayService? = null

    fun getAsteroidServiceProvider(): AsteroidApiService {
        if (asteroidServiceProvider != null) return asteroidServiceProvider as AsteroidApiService

        asteroidServiceProvider = AsteroidApiService()
        return asteroidServiceProvider as AsteroidApiService
    }

    fun getImageOfTheDayService(): ImageOfTheDayService {
        if (imageOfTheDayService != null) return imageOfTheDayService as ImageOfTheDayService

        imageOfTheDayService = ImageOfTheDayService()
        return imageOfTheDayService as ImageOfTheDayService
    }
}