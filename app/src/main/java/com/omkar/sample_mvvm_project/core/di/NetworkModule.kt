package com.omkar.sample_mvvm_project.core.di

import com.omkar.sample_mvvm_project.data.api.ApiServices
import com.omkar.sample_mvvm_project.core.common.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideUserServices(retrofit: Retrofit): ApiServices {

        return retrofit.create(ApiServices::class.java)

    }
}