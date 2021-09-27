package dev.marcocattaneo.robotpatternsample.presentation.list

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.marcocattaneo.robotpatternsample.R
import dev.marcocattaneo.robotpatternsample.domain.interactor.GetRepositories
import dev.marcocattaneo.robotpatternsample.presentation.common.StateViewModel
import dev.marcocattaneo.robotpatternsample.presentation.state.ErrorState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val getRepositories: GetRepositories
) : StateViewModel<ListState>(
    initialState = ListState()
) {

    fun fetch(username: String?) {
        username ?: return

        viewModelScope.launch {
            val result = getRepositories.perform(username)

            if (result.isSuccess) {
                emitState { state ->
                    state?.copy(
                        repositoriesList = result.getOrNull() ?: listOf()
                    )
                }
            } else {
                emitError(ErrorState(R.string.errors_api_failure))
            }
        }
    }

}