package ru.ladgertha.asteroidradar.room.contract

import ru.ladgertha.asteroidradar.room.BaseDao
import ru.ladgertha.asteroidradar.room.entity.ImageOfTheDayEntity

interface ImageOfTheDayContract {

    interface DAO : BaseDao<ImageOfTheDayEntity> {
        fun getImageOfTheDay(): ImageOfTheDayEntity?
        fun deleteYesterdayImage(date: String)

        companion object {
            const val TABLE_NAME_IMAGE_OF_THE_DAY = "IMAGE_OF_THE_DAY"
            const val KEY_IMAGE_OF_THE_DAY_URL = "IMAGE_OF_THE_DAY_URL"
            const val KEY_IMAGE_OF_THE_DAY_TITLE = "IMAGE_OF_THE_DAY_TITLE"
            const val KEY_IMAGE_OF_THE_DAY_MEDIA_TYPE = "IMAGE_OF_THE_DAY_MEDIA_TYPE"
            const val KEY_IMAGE_OF_THE_DAY_DATE = "IMAGE_OF_THE_DAY_DATE"
        }
    }
}