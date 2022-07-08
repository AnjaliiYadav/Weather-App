package com.yadavanjalii.weather_app.data.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
): Serializable