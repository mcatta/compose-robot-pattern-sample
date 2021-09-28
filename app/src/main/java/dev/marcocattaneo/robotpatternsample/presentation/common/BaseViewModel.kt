package dev.marcocattaneo.robotpatternsample.presentation.common

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import dev.marcocattaneo.robotpatternsample.presentation.Route
import dev.marcocattaneo.robotpatternsample.presentation.state.ErrorState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val mErrorState: MutableStateFlow<ErrorState?> = MutableStateFlow(value = null)
    val uiErrorState: StateFlow<ErrorState?>
        get() = mErrorState

    private lateinit var navHostController: NavHostController

    suspend fun emitError(errorState: ErrorState?) {
        mErrorState.emit(errorState)
    }

    fun registerNavHostController(navHostController: NavHostController) {
        this.navHostController = navHostController
    }

    protected fun navigateTo(route: Route) = navHostController.navigate(route.getNavigableRoute())

    fun dismissError() {
        viewModelScope.launch {
            emitError(null)
        }
    }

    @Composable
    abstract fun getSectionHeaderTitle(): String

}