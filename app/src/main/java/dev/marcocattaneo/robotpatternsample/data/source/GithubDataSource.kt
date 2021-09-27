package dev.marcocattaneo.robotpatternsample.data.source

import dev.marcocattaneo.robotpatternsample.data.http.GithubService
import dev.marcocattaneo.robotpatternsample.domain.domain.GithubRepo
import dev.marcocattaneo.robotpatternsample.domain.repository.GithubRepository
import javax.inject.Inject

class GithubDataSource @Inject constructor(
    val githubService: GithubService
) : GithubRepository {

    override suspend fun repositoriesByName(username: String): List<GithubRepo> {
        return githubService.repositories(username)
    }

}