package com.yadavanjalii.common.core

import android.annotation.SuppressLint
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yadavanjalii.common.constants.Constants.TAG
import com.yadavanjalii.common.utils.Helper
import com.yadavanjalii.weather_app.BR
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
object BindAdapters {
    @JvmStatic
    @BindingAdapter("layout", "list", "click")
    fun <T> setRecyclerView(
        view: RecyclerView,
        layout: Int,
        list: List<T>?,
        click: RvClickListener
    ) {
        if (list != null) {
            val adapter = GlobalAdapter(
                layout,
                list.toMutableList(),
                BR.model,
                clickListener = click,
                mapOf(BR.itemclick to click)
            )
            Helper.print("item click ${mapOf(BR.itemclick to click)}")
            view.adapter = adapter
        }
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setSrc(
        view: ImageView,
        imageCode: String?,
    ) {

        try {
            val url = "https://openweathermap.org/img/w/$imageCode.png"

            Log.d(TAG, "setSrc: $url")
            val options: RequestOptions = RequestOptions()
                .centerInside()
            view.scaleType = ImageView.ScaleType.FIT_CENTER
            Glide.with(view.context)
                .load(url)
                .apply(options)
                .into(view)
        } catch (e: Exception) {
            Log.d(TAG, "setSrc: ${e.message}")
        }
    }


    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("temperature")
    fun setTemperature(view: TextView, tempK: Double) {
        val num = 273.15
        val celsius = ((tempK - num) * 10).roundToInt() / 10
        view.text = (celsius).toString() + " \u2103";
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("minTemperature")
    fun setMinTemperature(view: TextView, tempK: Double) {
        val num = 273.15
        val celsius = ((tempK - num) * 10).roundToInt() / 10
        view.text = "Min: " + (celsius).toString() + " \u2103";
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("maxTemperature")
    fun setMaxTemperature(view: TextView, tempK: Double) {
        val num = 273.15
        val celsius = ((tempK - num) * 10).roundToInt() / 10
        view.text = "Max: " + (celsius).toString() + " \u2103";
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("humidity")
    fun setHumidityPercent(view: TextView, humidity: Int) {
        view.text = "Humidity: $humidity %";
    }


}
