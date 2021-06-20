package ru.ladgertha.asteroidradar.utils

import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    private val dataFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private const val DAYS_OF_WEEK = 7
    fun getYesterday(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -1)
        return dataFormat.format(calendar.time)
    }

    fun getToday(): String = dataFormat.format(Calendar.getInstance().time)

    fun getDayAfterAWeek(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, DAYS_OF_WEEK)
        return dataFormat.format(calendar.time)
    }

    fun getNextSevenDates(): ArrayList<String> {
        val formattedDateList = ArrayList<String>()

        val calendar = Calendar.getInstance()
        for (i in 0..DAYS_OF_WEEK) {
            val currentTime = calendar.time
            formattedDateList.add(dataFormat.format(calendar.time))
            calendar.add(Calendar.DAY_OF_YEAR, 1)
        }

        return formattedDateList
    }
}