package com.yadavanjalii.weather_app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.yadavanjalii.weather_app.data.repos.WeatherRepos
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repos: WeatherRepos
) : ViewModel() {

    fun getForecast(city: String) = liveData(Dispatchers.IO) {
        emit(repos.getForecast(city))
    }

    fun getWeather(city: String) = liveData(Dispatchers.IO) {
        emit(repos.getWeather(city))
    }
}