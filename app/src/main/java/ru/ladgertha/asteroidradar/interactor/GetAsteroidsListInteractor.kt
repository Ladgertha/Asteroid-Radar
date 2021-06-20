package ru.ladgertha.asteroidradar.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ladgertha.asteroidradar.api.Asteroid
import ru.ladgertha.asteroidradar.repository.AsteroidRepository
import ru.ladgertha.asteroidradar.utils.AsteroidsFilter

class GetAsteroidsListInteractor(
    private val asteroidRepository: AsteroidRepository
) {

    suspend fun getAsteroidsList(): List<Asteroid> {
        return withContext(Dispatchers.IO) {
            asteroidRepository.getAsteroidsList()
        }
    }

    suspend fun getAsteroidListWithFilter(filter: AsteroidsFilter): List<Asteroid> {
        return withContext(Dispatchers.IO) {
            asteroidRepository.getAsteroidListWithFilter(filter)
        }
    }
}