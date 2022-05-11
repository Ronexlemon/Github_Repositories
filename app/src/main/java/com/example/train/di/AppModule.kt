package com.example.train.di

import com.example.train.constants.AppConstants.Base_URL
import com.example.train.network.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideBaseUrl(): String {
        return Base_URL
    }
    @Singleton
    @Provides
    fun provideGsonConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
    @Singleton
    @Provides
    fun providesRetrofitInstance(converter:GsonConverterFactory,Base_Url:String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(converter)
            .build()
    }
    @Singleton
     @Provides
     fun providesService(retro: Retrofit): NetworkService {
         return retro.create(NetworkService::class.java)
     }
}