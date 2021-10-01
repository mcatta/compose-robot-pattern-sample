package dev.marcocattaneo.robotpatternsample.utils

import dev.marcocattaneo.robotpatternsample.domain.domain.GithubRepo

object TestUtils {

    fun fakeRepo() = GithubRepo(
        id = 0L,
        name = "Repo-${System.currentTimeMillis()}",
        full_name = "Repo full ${System.currentTimeMillis()}",
        private = false,
        description = "Description",
        url = "https://github.com/mcatta",
        owner = GithubRepo.Owner(
            login = "mcatta",
            id = 0L
        )
    )
}