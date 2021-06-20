package ru.ladgertha.asteroidradar.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ladgertha.asteroidradar.api.ImageOfTheDay
import ru.ladgertha.asteroidradar.repository.ImageOfTheDayRepository

class GetImageOfTheDayInteractor(
    private val imageOfTheDayRepository: ImageOfTheDayRepository
) {

    suspend fun getImageOfTheDay(): ImageOfTheDay {
        return withContext(Dispatchers.IO) {
            imageOfTheDayRepository.getSavedImage()
        }
    }
}