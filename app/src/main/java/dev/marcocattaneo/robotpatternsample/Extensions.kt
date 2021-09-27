package dev.marcocattaneo.robotpatternsample

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import dev.marcocattaneo.robotpatternsample.presentation.common.StateViewModel
import dev.marcocattaneo.robotpatternsample.presentation.Route
import dev.marcocattaneo.robotpatternsample.presentation.common.BaseViewModel
import dev.marcocattaneo.robotpatternsample.presentation.common.ScreenContainer
import dev.marcocattaneo.robotpatternsample.presentation.state.VMState

inline fun <reified VM : BaseViewModel> NavGraphBuilder.composable(
    route: Route,
    navHostController: NavHostController,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    crossinline content: @Composable (NavBackStackEntry, VM) -> Unit
) {
    composable(route.path, arguments, deepLinks) {
        val vm = hiltViewModel<VM>()
        vm.registerNavHostController(navHostController = navHostController)

        ScreenContainer(
            baseViewModel = vm,
            content = {
                content(it, vm)
            }
        )
    }
}