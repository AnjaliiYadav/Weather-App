package com.yadavanjalii.weather_app.data.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Coord(
    val lat: Double,
    val lon: Double
): Serializable