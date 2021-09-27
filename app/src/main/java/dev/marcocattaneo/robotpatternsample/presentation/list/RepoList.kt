package dev.marcocattaneo.robotpatternsample.presentation.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.marcocattaneo.robotpatternsample.domain.domain.GithubRepo
import dev.marcocattaneo.robotpatternsample.ui.theme.Dimen

@Composable
fun RepoList(repoListViewModel: RepoListViewModel, username: String?) {
    val uiState by repoListViewModel.uiState.collectAsState()

    repoListViewModel.fetch(username)

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(Dimen.Normal)
    ) {
        uiState?.repositoriesList?.forEach { repository ->
            item { RepoItem(repository) }
        }
    }
}

@Composable
private fun RepoItem(repository: GithubRepo) {
    Card(
        elevation = Dimen.DefaultElevation,
        modifier = Modifier
            .padding(Dimen.Normal)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                modifier = Modifier.padding(Dimen.Normal),
                text = repository.name,
                style = MaterialTheme.typography.h5
            )
            Text(
                modifier = Modifier.padding(Dimen.Normal),
                text = repository.owner.login,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Composable
@Preview(backgroundColor = 0xFFFFFFF)
private fun RepoItemPreview() {
    RepoItem(
        GithubRepo(
            id = 42,
            name = "My Sample",
            full_name = "my-sample",
            private = false,
            url = "https://mcatta.github.com",
            description = "A short description about nothig",
            owner = GithubRepo.Owner("mcatta", 42)
        )
    )
}