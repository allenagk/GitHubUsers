package com.allensdroid.githubusers.di

import com.allensdroid.githubusers.data.remote.GiHubApi
import com.allensdroid.githubusers.data.repository.GithubRepositoryImpl
import com.allensdroid.githubusers.domain.repository.GithubRepository
import com.allensdroid.githubusers.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideGithubApi(): GiHubApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GiHubApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGithubRepository(api: GiHubApi): GithubRepository {
        return GithubRepositoryImpl(api)
    }
}