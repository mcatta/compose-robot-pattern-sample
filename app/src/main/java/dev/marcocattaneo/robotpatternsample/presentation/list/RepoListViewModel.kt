package dev.marcocattaneo.robotpatternsample.presentation.list

import dagger.hilt.android.lifecycle.HiltViewModel
import dev.marcocattaneo.robotpatternsample.presentation.BaseViewModel
import dev.marcocattaneo.robotpatternsample.presentation.state.VMState
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(

) : BaseViewModel<VMState>(
    initialState = null
) {

}