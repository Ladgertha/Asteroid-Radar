package ru.ladgertha.asteroidradar.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ladgertha.asteroidradar.interactor.GetAsteroidsListInteractor
import ru.ladgertha.asteroidradar.interactor.GetImageOfTheDayInteractor

class ViewModelFactory(
    private val getAsteroidsListInteractor: GetAsteroidsListInteractor,
    private val getImageOfTheDayInteractor: GetImageOfTheDayInteractor
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(getAsteroidsListInteractor, getImageOfTheDayInteractor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
