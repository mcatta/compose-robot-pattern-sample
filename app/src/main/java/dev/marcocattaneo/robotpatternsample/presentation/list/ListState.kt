package dev.marcocattaneo.robotpatternsample.presentation.list

import dev.marcocattaneo.robotpatternsample.domain.domain.GithubRepo
import dev.marcocattaneo.robotpatternsample.presentation.state.VMState

data class ListState(
    val repositoriesList: List<GithubRepo> = listOf()
): VMState()