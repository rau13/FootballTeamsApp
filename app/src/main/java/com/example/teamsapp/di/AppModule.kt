package com.example.teamsapp.di

import android.app.Application
import androidx.room.Room
import com.example.teamsapp.api.ApiService
import com.example.teamsapp.db.TeamsDatabase
import com.example.teamsapp.helper.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideTeamsApi(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : TeamsDatabase =
        Room.databaseBuilder(app, TeamsDatabase::class.java, "teams_database")
            .build()

}