package dev.marcocattaneo.robotpatternsample.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.marcocattaneo.robotpatternsample.data.http.GithubService
import dev.marcocattaneo.robotpatternsample.data.source.GithubDataSource
import dev.marcocattaneo.robotpatternsample.domain.repository.GithubRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .build()

    @Provides
    @Singleton
    fun provideGithubRepository(retrofit: Retrofit): GithubRepository = GithubDataSource(
        retrofit.create(GithubService::class.java)
    )

}