package dev.marcocattaneo.robotpatternsample.domain.repository

import dev.marcocattaneo.robotpatternsample.domain.domain.GithubRepo

interface GithubRepository {

    suspend fun repositoriesByName(username: String): List<GithubRepo>

}