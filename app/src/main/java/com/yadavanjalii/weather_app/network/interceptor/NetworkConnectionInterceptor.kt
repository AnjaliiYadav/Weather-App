package com.yadavanjalii.weather_app.network.interceptor

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.yadavanjalii.common.exceptions.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
class NetworkConnectionInterceptor( val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnected()) {
            throw NoConnectivityException()
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    private fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
            -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH)
            -> false
            else -> false
        }

    }
}