package com.yadavanjalii.weather_app.data.repos

import com.yadavanjalii.weather_app.network.services.ApiService
import javax.inject.Inject

/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
class WeatherRepos @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getForecast(city: String) = apiService.getWeatherForecast(city)
    suspend fun getWeather(city: String) = apiService.getWeather(city)

}