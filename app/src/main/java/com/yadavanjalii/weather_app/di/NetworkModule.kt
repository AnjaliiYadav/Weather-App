package com.yadavanjalii.weather_app.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yadavanjalii.common.constants.Constants.BASE_URL
import com.yadavanjalii.common.constants.Constants.TIME_MILLISECONDS
import com.yadavanjalii.weather_app.BuildConfig
import com.yadavanjalii.weather_app.network.interceptor.NetworkConnectionInterceptor
import com.yadavanjalii.weather_app.network.services.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    internal fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    internal fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor,
        context: Context
    ): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(TIME_MILLISECONDS, TimeUnit.MILLISECONDS)
            .readTimeout(TIME_MILLISECONDS, TimeUnit.MILLISECONDS)
            .writeTimeout(TIME_MILLISECONDS, TimeUnit.MILLISECONDS)
            .addInterceptor(interceptor)
        context.let {
            httpClient.addInterceptor(NetworkConnectionInterceptor(it))
        }

        return httpClient.build()
    }

    @Provides
    internal fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    internal fun providesHTTPLoginInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}