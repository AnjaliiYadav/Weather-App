package com.yadavanjalii.weather_app.data.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class City(
    val coord: Coord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
): Serializable