package ru.ladgertha.asteroidradar.room

import ru.ladgertha.asteroidradar.room.contract.AsteroidContract
import ru.ladgertha.asteroidradar.room.contract.ImageOfTheDayContract

interface StorageDatabase {

    fun asteroidDao(): AsteroidContract.DAO

    fun imageOfTheDayDao(): ImageOfTheDayContract.DAO
}