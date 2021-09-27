package dev.marcocattaneo.robotpatternsample.presentation.common

import dev.marcocattaneo.robotpatternsample.presentation.state.VMState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class StateViewModel<VMS : VMState> constructor(
    initialState: VMS?
) : BaseViewModel() {

    private val mState: MutableStateFlow<VMS?> = MutableStateFlow(value = initialState)
    val uiState: StateFlow<VMS?>
        get() = mState


    protected suspend fun emitState(stateBlock: (VMS?) -> VMS?) = mState.emit(stateBlock(mState.value))

}