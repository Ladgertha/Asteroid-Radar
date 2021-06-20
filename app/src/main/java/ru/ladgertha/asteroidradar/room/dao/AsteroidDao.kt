package ru.ladgertha.asteroidradar.room.dao

import androidx.room.Dao
import androidx.room.Query
import ru.ladgertha.asteroidradar.room.contract.AsteroidContract
import ru.ladgertha.asteroidradar.room.entity.AsteroidEntity

@Dao
abstract class AsteroidDao : AsteroidContract.DAO {

    @Query("SELECT * FROM ${AsteroidContract.DAO.TABLE_NAME_ASTEROIDS} ORDER BY ${AsteroidContract.DAO.KEY_ASTEROID_CLOSE_APPROACH_DATE}")
    abstract override fun getAsteroidsList(): List<AsteroidEntity>

    @Query("SELECT * FROM ${AsteroidContract.DAO.TABLE_NAME_ASTEROIDS} WHERE ${AsteroidContract.DAO.KEY_ASTEROID_CLOSE_APPROACH_DATE} = :date ORDER BY ${AsteroidContract.DAO.KEY_ASTEROID_CLOSE_APPROACH_DATE}")
    abstract override fun getAsteroidsListForToday(date: String): List<AsteroidEntity>

    @Query("SELECT * FROM ${AsteroidContract.DAO.TABLE_NAME_ASTEROIDS} WHERE ${AsteroidContract.DAO.KEY_ASTEROID_CLOSE_APPROACH_DATE} BETWEEN :startDate AND :endDate ORDER BY ${AsteroidContract.DAO.KEY_ASTEROID_CLOSE_APPROACH_DATE}")
    abstract override fun getAsteroidsListForPeriod(
        startDate: String,
        endDate: String
    ): List<AsteroidEntity>

    @Query("DELETE FROM ${AsteroidContract.DAO.TABLE_NAME_ASTEROIDS} WHERE ${AsteroidContract.DAO.KEY_ASTEROID_CLOSE_APPROACH_DATE} = :date")
    abstract override fun deleteYesterdayAsteroids(date: String)
}