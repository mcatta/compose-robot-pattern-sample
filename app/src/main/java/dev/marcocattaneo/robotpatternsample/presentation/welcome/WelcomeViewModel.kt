package dev.marcocattaneo.robotpatternsample.presentation.welcome

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.marcocattaneo.robotpatternsample.presentation.common.StateViewModel
import dev.marcocattaneo.robotpatternsample.presentation.Route
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor() : StateViewModel<WelcomeState>(
    initialState = WelcomeState()
) {

    fun onChangeUsername(username: String) {
        viewModelScope.launch {
            emitState {
                it?.copy(
                    username = username
                )
            }
        }
    }

    fun confirm() = navigateTo(Route.RepoList(uiState.value!!.username))

}