package ru.ladgertha.asteroidradar.mapper

import ru.ladgertha.asteroidradar.api.ImageOfTheDay
import ru.ladgertha.asteroidradar.room.entity.ImageOfTheDayEntity
import ru.ladgertha.asteroidradar.utils.DateHelper

object ImageOfTheDayMapper {

    fun mapToDatabaseEntity(imageOfTheDay: ImageOfTheDay): ImageOfTheDayEntity {
        return ImageOfTheDayEntity(
            url = imageOfTheDay.url,
            title = imageOfTheDay.title,
            mediaType = imageOfTheDay.mediaType,
            date = DateHelper.getToday()
        )
    }

    fun mapFromDatabaseEntity(imageOfTheDayEntity: ImageOfTheDayEntity): ImageOfTheDay {
        return ImageOfTheDay(
            url = imageOfTheDayEntity.url,
            title = imageOfTheDayEntity.title,
            mediaType = imageOfTheDayEntity.mediaType
        )
    }
}