package com.yadavanjalii.weather_app.data.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
): Serializable