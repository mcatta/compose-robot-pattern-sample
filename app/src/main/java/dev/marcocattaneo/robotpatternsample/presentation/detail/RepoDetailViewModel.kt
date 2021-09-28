package dev.marcocattaneo.robotpatternsample.presentation.detail

import androidx.compose.runtime.Composable
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.marcocattaneo.robotpatternsample.presentation.common.StateViewModel
import dev.marcocattaneo.robotpatternsample.presentation.state.VMState
import javax.inject.Inject

@HiltViewModel
class RepoDetailViewModel @Inject constructor(

) : StateViewModel<VMState>(
    initialState = null
) {
    @Composable
    override fun getSectionHeaderTitle() = ""
}