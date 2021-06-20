package ru.ladgertha.asteroidradar.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.ladgertha.asteroidradar.api.Asteroid
import ru.ladgertha.asteroidradar.api.ImageOfTheDay
import ru.ladgertha.asteroidradar.interactor.GetAsteroidsListInteractor
import ru.ladgertha.asteroidradar.interactor.GetImageOfTheDayInteractor
import ru.ladgertha.asteroidradar.utils.AsteroidsFilter
import ru.ladgertha.asteroidradar.utils.LoadingStatus

class MainViewModel(
    private val getAsteroidsListInteractor: GetAsteroidsListInteractor,
    private val getImageOfTheDayInteractor: GetImageOfTheDayInteractor
) : ViewModel() {

    private val _imageOfTheDay = MutableLiveData<ImageOfTheDay>()
    val imageOfTheDay: LiveData<ImageOfTheDay>
        get() = _imageOfTheDay

    private val _asteroidsList = MutableLiveData<List<Asteroid>>()
    val asteroidsList: LiveData<List<Asteroid>>
        get() = _asteroidsList
    private val _loadingStatus = MutableLiveData<LoadingStatus>()
    val loadingStatus: LiveData<LoadingStatus>
        get() = _loadingStatus

    init {
        viewModelScope.launch {
            _loadingStatus.value = LoadingStatus.SHOW
            _asteroidsList.value = getAsteroidsListInteractor.getAsteroidsList()
            _imageOfTheDay.value = getImageOfTheDayInteractor.getImageOfTheDay()
            _loadingStatus.value = LoadingStatus.HIDE
        }
    }

    fun updateAsteroidsListWithFilter(filter: AsteroidsFilter) {
        viewModelScope.launch {
            _loadingStatus.value = LoadingStatus.SHOW
            _asteroidsList.value = getAsteroidsListInteractor.getAsteroidListWithFilter(filter)
            _loadingStatus.value = LoadingStatus.HIDE
        }
    }
}