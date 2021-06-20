package ru.ladgertha.asteroidradar.repository

import org.json.JSONObject
import retrofit2.await
import ru.ladgertha.asteroidradar.api.Asteroid
import ru.ladgertha.asteroidradar.api.service.AsteroidApiService
import ru.ladgertha.asteroidradar.mapper.AsteroidMapper
import ru.ladgertha.asteroidradar.room.AsteroidDatabase
import ru.ladgertha.asteroidradar.utils.AsteroidsFilter
import ru.ladgertha.asteroidradar.utils.DateHelper
import ru.ladgertha.asteroidradar.utils.parseAsteroidsJsonResult

class AsteroidRepository(
    private val apiKey: String,
    private val database: AsteroidDatabase,
    private val asteroidApiService: AsteroidApiService
) {

    suspend fun getAsteroidsList(): List<Asteroid> {
        val savedAsteroidsList = database.asteroidDao().getAsteroidsList()
        if (savedAsteroidsList.isNotEmpty()) return AsteroidMapper.mapFromDatabaseEntity(
            savedAsteroidsList
        )

        return updateAsteroidList()
    }

    suspend fun getAsteroidListWithFilter(filter: AsteroidsFilter): List<Asteroid> {
        val list = getAsteroidListFromDatabase(filter)
        if (list.isNullOrEmpty()) {
            val asteroidListFromApi =
                asteroidApiService.retrofitService.getAsteroidList(apiKey).await()
            val parsedResult = parseAsteroidsJsonResult(JSONObject(asteroidListFromApi))
            database.asteroidDao().insert(AsteroidMapper.mapToDatabaseEntity(parsedResult))
            return AsteroidMapper.mapFromDatabaseEntity(getAsteroidListFromDatabase(filter))
        }

        return AsteroidMapper.mapFromDatabaseEntity(list)
    }

    fun deleteYesterdayAsteroids() {
        database.asteroidDao().deleteYesterdayAsteroids(DateHelper.getYesterday())
    }

    suspend fun updateAsteroidList(): List<Asteroid> {
        val asteroidListFromApi = asteroidApiService.retrofitService.getAsteroidList(apiKey).await()
        val parsedResult = parseAsteroidsJsonResult(JSONObject(asteroidListFromApi))
        database.asteroidDao().insert(AsteroidMapper.mapToDatabaseEntity(parsedResult))
        return parsedResult
    }

    private fun getAsteroidListFromDatabase(filter: AsteroidsFilter) =
        when (filter) {
            AsteroidsFilter.TODAY -> {
                database.asteroidDao()
                    .getAsteroidsListForToday(DateHelper.getToday())
            }
            AsteroidsFilter.WEEK -> {
                database.asteroidDao()
                    .getAsteroidsListForPeriod(DateHelper.getToday(), DateHelper.getDayAfterAWeek())
            }
            AsteroidsFilter.ALL -> database.asteroidDao().getAsteroidsList()
        }
}
