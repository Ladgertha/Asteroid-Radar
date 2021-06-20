package ru.ladgertha.asteroidradar.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.ladgertha.asteroidradar.room.contract.ImageOfTheDayContract
import ru.ladgertha.asteroidradar.room.contract.ImageOfTheDayContract.DAO.Companion.KEY_IMAGE_OF_THE_DAY_DATE
import ru.ladgertha.asteroidradar.room.contract.ImageOfTheDayContract.DAO.Companion.KEY_IMAGE_OF_THE_DAY_MEDIA_TYPE
import ru.ladgertha.asteroidradar.room.contract.ImageOfTheDayContract.DAO.Companion.KEY_IMAGE_OF_THE_DAY_TITLE
import ru.ladgertha.asteroidradar.room.contract.ImageOfTheDayContract.DAO.Companion.KEY_IMAGE_OF_THE_DAY_URL

@Entity(tableName = ImageOfTheDayContract.DAO.TABLE_NAME_IMAGE_OF_THE_DAY)
data class ImageOfTheDayEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = KEY_IMAGE_OF_THE_DAY_URL)
    val url: String,

    @ColumnInfo(name = KEY_IMAGE_OF_THE_DAY_TITLE)
    val title: String,

    @ColumnInfo(name = KEY_IMAGE_OF_THE_DAY_MEDIA_TYPE)
    val mediaType: String,

    @ColumnInfo(name = KEY_IMAGE_OF_THE_DAY_DATE, index = true)
    val date: String
)