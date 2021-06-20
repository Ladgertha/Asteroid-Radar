package ru.ladgertha.asteroidradar.room.dao

import androidx.room.Dao
import androidx.room.Query
import ru.ladgertha.asteroidradar.room.contract.ImageOfTheDayContract
import ru.ladgertha.asteroidradar.room.entity.ImageOfTheDayEntity

@Dao
abstract class ImageOfTheDayDao : ImageOfTheDayContract.DAO {

    @Query(
        "SELECT * FROM ${
            ImageOfTheDayContract.DAO.TABLE_NAME_IMAGE_OF_THE_DAY
        } LIMIT 1"
    )
    abstract override fun getImageOfTheDay(): ImageOfTheDayEntity?

    @Query(
        "DELETE FROM ${
            ImageOfTheDayContract.DAO.TABLE_NAME_IMAGE_OF_THE_DAY
        } WHERE ${ImageOfTheDayContract.DAO.KEY_IMAGE_OF_THE_DAY_DATE} = :date"
    )
    abstract override fun deleteYesterdayImage(date: String)
}