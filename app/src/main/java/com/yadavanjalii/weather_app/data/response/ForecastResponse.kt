package com.yadavanjalii.weather_app.data.response

import androidx.annotation.Keep
import com.yadavanjalii.weather_app.data.model.City
import com.yadavanjalii.weather_app.data.model.Details
import java.io.Serializable

@Keep
data class ForecastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Details>,
    val message: Int,
    val timezone: Int,
): Serializable