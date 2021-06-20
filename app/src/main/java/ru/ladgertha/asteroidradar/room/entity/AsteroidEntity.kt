package ru.ladgertha.asteroidradar.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.ladgertha.asteroidradar.room.contract.AsteroidContract.DAO.Companion.KEY_ASTEROID_ABSOLUTE_MAGNITUDE
import ru.ladgertha.asteroidradar.room.contract.AsteroidContract.DAO.Companion.KEY_ASTEROID_CLOSE_APPROACH_DATE
import ru.ladgertha.asteroidradar.room.contract.AsteroidContract.DAO.Companion.KEY_ASTEROID_CODE_NAME
import ru.ladgertha.asteroidradar.room.contract.AsteroidContract.DAO.Companion.KEY_ASTEROID_DISTANCE_FROM_EARTH
import ru.ladgertha.asteroidradar.room.contract.AsteroidContract.DAO.Companion.KEY_ASTEROID_ESTIMATED_DIAMETER
import ru.ladgertha.asteroidradar.room.contract.AsteroidContract.DAO.Companion.KEY_ASTEROID_ID
import ru.ladgertha.asteroidradar.room.contract.AsteroidContract.DAO.Companion.KEY_ASTEROID_IS_POTENTIALLY_HAZARDOUS
import ru.ladgertha.asteroidradar.room.contract.AsteroidContract.DAO.Companion.KEY_ASTEROID_RELATIVE_VELOCITY
import ru.ladgertha.asteroidradar.room.contract.AsteroidContract.DAO.Companion.TABLE_NAME_ASTEROIDS

@Entity(tableName = TABLE_NAME_ASTEROIDS)
data class AsteroidEntity(
    @PrimaryKey
    @ColumnInfo(name = KEY_ASTEROID_ID)
    val id: Long,

    @ColumnInfo(name = KEY_ASTEROID_CODE_NAME)
    val codename: String,

    @ColumnInfo(name = KEY_ASTEROID_CLOSE_APPROACH_DATE, index = true)
    val closeApproachDate: String,

    @ColumnInfo(name = KEY_ASTEROID_ABSOLUTE_MAGNITUDE)
    val absoluteMagnitude: Double,

    @ColumnInfo(name = KEY_ASTEROID_ESTIMATED_DIAMETER)
    val estimatedDiameter: Double,

    @ColumnInfo(name = KEY_ASTEROID_RELATIVE_VELOCITY)
    val relativeVelocity: Double,

    @ColumnInfo(name = KEY_ASTEROID_DISTANCE_FROM_EARTH)
    val distanceFromEarth: Double,

    @ColumnInfo(name = KEY_ASTEROID_IS_POTENTIALLY_HAZARDOUS)
    val isPotentiallyHazardous: Boolean
)