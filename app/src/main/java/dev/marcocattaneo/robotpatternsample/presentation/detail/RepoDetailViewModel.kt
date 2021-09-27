package dev.marcocattaneo.robotpatternsample.presentation.detail

import dagger.hilt.android.lifecycle.HiltViewModel
import dev.marcocattaneo.robotpatternsample.presentation.BaseViewModel
import dev.marcocattaneo.robotpatternsample.presentation.state.VMState
import javax.inject.Inject

@HiltViewModel
class RepoDetailViewModel @Inject constructor(

) : BaseViewModel<VMState>(
    initialState = null
)