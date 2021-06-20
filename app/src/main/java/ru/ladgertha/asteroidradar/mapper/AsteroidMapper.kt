package ru.ladgertha.asteroidradar.mapper

import ru.ladgertha.asteroidradar.api.Asteroid
import ru.ladgertha.asteroidradar.room.entity.AsteroidEntity

object AsteroidMapper {

    fun mapToDatabaseEntity(asteroidList: List<Asteroid>): List<AsteroidEntity> {
        return asteroidList.map {
            mapToDatabaseEntity(it)
        }
    }

    private fun mapToDatabaseEntity(asteroid: Asteroid): AsteroidEntity {
        return AsteroidEntity(
            id = asteroid.id,
            codename = asteroid.codename,
            closeApproachDate = asteroid.closeApproachDate,
            absoluteMagnitude = asteroid.absoluteMagnitude,
            estimatedDiameter = asteroid.estimatedDiameter,
            relativeVelocity = asteroid.relativeVelocity,
            distanceFromEarth = asteroid.distanceFromEarth,
            isPotentiallyHazardous = asteroid.isPotentiallyHazardous
        )
    }

    fun mapFromDatabaseEntity(asteroidList: List<AsteroidEntity>): List<Asteroid> {
        return asteroidList.map {
            mapFromDatabaseEntity(it)
        }
    }

    private fun mapFromDatabaseEntity(asteroid: AsteroidEntity): Asteroid {
        return Asteroid(
            id = asteroid.id,
            codename = asteroid.codename,
            closeApproachDate = asteroid.closeApproachDate,
            absoluteMagnitude = asteroid.absoluteMagnitude,
            estimatedDiameter = asteroid.estimatedDiameter,
            relativeVelocity = asteroid.relativeVelocity,
            distanceFromEarth = asteroid.distanceFromEarth,
            isPotentiallyHazardous = asteroid.isPotentiallyHazardous
        )
    }
}