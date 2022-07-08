package com.yadavanjalii.weather_app.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext;
    }
}