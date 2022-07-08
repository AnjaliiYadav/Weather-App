package com.yadavanjalii.weather_app.data.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Main(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double
): Serializable