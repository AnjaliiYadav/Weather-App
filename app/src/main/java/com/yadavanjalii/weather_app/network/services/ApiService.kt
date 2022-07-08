package com.yadavanjalii.weather_app.network.services

import com.yadavanjalii.weather_app.BuildConfig
import com.yadavanjalii.weather_app.data.response.ForecastResponse
import com.yadavanjalii.weather_app.data.response.WeatherResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
interface ApiService {

    //https://api.openweathermap.org/data/2.5/forecast?q={city name}&appid={API key}
    @GET("forecast")
    suspend fun getWeatherForecast(
        @Query("q") q: String,
        @Query("appid") appid: String = BuildConfig.apiKey
    ): Response<ForecastResponse>


    //https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
    @GET("weather")
    suspend fun getWeather(
        @Query("q") q: String,
        @Query("appid") appid: String = BuildConfig.apiKey
    ): Response<WeatherResponse>

}