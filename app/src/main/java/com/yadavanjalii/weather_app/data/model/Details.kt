package com.yadavanjalii.weather_app.data.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Details(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
): Serializable