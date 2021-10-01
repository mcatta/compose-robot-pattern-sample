package dev.marcocattaneo.robotpatternsample.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import dev.marcocattaneo.robotpatternsample.domain.repository.GithubRepository
import io.mockk.mockk
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class]
)
object FakeNetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = mockk()

    @Provides
    @Singleton
    fun provideGithubRepository(retrofit: Retrofit): GithubRepository = mockk()

}