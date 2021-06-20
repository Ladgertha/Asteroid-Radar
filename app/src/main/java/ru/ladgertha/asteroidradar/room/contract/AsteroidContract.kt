package ru.ladgertha.asteroidradar.room.contract

import ru.ladgertha.asteroidradar.room.BaseDao
import ru.ladgertha.asteroidradar.room.entity.AsteroidEntity

interface AsteroidContract {

    interface DAO : BaseDao<AsteroidEntity> {
        fun getAsteroidsList(): List<AsteroidEntity>
        fun getAsteroidsListForPeriod(startDate: String, endDate: String): List<AsteroidEntity>
        fun getAsteroidsListForToday(date: String): List<AsteroidEntity>
        fun deleteYesterdayAsteroids(date: String)

        companion object {
            const val TABLE_NAME_ASTEROIDS = "ASTEROID"
            const val KEY_ASTEROID_ID = "ASTEROID_ID"
            const val KEY_ASTEROID_CODE_NAME = "ASTEROID_CODE_NAME"
            const val KEY_ASTEROID_CLOSE_APPROACH_DATE = "ASTEROID_CLOSE_APPROACH_DATE"
            const val KEY_ASTEROID_ABSOLUTE_MAGNITUDE = "ASTEROID_ABSOLUTE_MAGNITUDE"
            const val KEY_ASTEROID_ESTIMATED_DIAMETER = "ASTEROID_ESTIMATED_DIAMETER"
            const val KEY_ASTEROID_RELATIVE_VELOCITY = "ASTEROID_RELATIVE_VELOCITY"
            const val KEY_ASTEROID_DISTANCE_FROM_EARTH = "ASTEROID_DISTANCE_FROM_EARTH"
            const val KEY_ASTEROID_IS_POTENTIALLY_HAZARDOUS = "ASTEROID_IS_POTENTIALLY_HAZARDOUS"
        }
    }
}