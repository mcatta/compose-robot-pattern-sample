package dev.marcocattaneo.robotpatternsample.domain.interactor

import dagger.hilt.android.scopes.ActivityRetainedScoped
import dev.marcocattaneo.robotpatternsample.domain.domain.GithubRepo
import dev.marcocattaneo.robotpatternsample.domain.repository.GithubRepository
import java.lang.Exception
import javax.inject.Inject

@ActivityRetainedScoped
class GetRepositories @Inject constructor(
    private val repository: GithubRepository
): UseCase<String, List<GithubRepo>> {
    override suspend fun perform(input: String): Result<List<GithubRepo>> {
        return try {
            Result.success(repository.repositoriesByName(input))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}