package ru.ladgertha.asteroidradar.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.ladgertha.asteroidradar.room.dao.AsteroidDao
import ru.ladgertha.asteroidradar.room.dao.ImageOfTheDayDao
import ru.ladgertha.asteroidradar.room.entity.AsteroidEntity
import ru.ladgertha.asteroidradar.room.entity.ImageOfTheDayEntity

@Database(
    entities = [
        AsteroidEntity::class,
        ImageOfTheDayEntity::class
    ],
    exportSchema = true,
    version = 1
)
abstract class AsteroidDatabase : RoomDatabase(), StorageDatabase {

    abstract override fun asteroidDao(): AsteroidDao

    abstract override fun imageOfTheDayDao(): ImageOfTheDayDao

    companion object {
        private const val DATABASE_NAME = "asteroid_radar.db"

        @Volatile
        private var INSTANCE: AsteroidDatabase? = null

        fun getDatabase(context: Context): AsteroidDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: create(context).also { INSTANCE = it }
            }

        private fun create(context: Context): AsteroidDatabase =
            Room.databaseBuilder(
                context,
                AsteroidDatabase::class.java,
                DATABASE_NAME
            )
                .build()
    }
}