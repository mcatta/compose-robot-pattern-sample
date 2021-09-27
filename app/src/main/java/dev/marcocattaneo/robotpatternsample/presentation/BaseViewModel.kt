package dev.marcocattaneo.robotpatternsample.presentation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import dev.marcocattaneo.robotpatternsample.presentation.state.VMState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<VMS : VMState> constructor(
    initialState: VMS?
) : ViewModel() {

    private val mState: MutableStateFlow<VMS?> = MutableStateFlow(value = initialState)
    val uiState: StateFlow<VMS?>
        get() = mState

    private lateinit var navHostController: NavHostController

    fun registerNavHostController(navHostController: NavHostController) {
        this.navHostController = navHostController
    }

    protected suspend fun emitState(stateBlock: (VMS?) -> VMS?) = mState.emit(stateBlock(mState.value))

    protected fun navigateTo(route: Route) = navHostController.navigate(route.getNavigableRoute())

}