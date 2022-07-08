package com.yadavanjalii.weather_app.data.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Sys(
    val pod: String,
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
): Serializable