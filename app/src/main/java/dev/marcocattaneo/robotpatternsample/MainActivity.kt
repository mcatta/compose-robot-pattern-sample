package dev.marcocattaneo.robotpatternsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import dev.marcocattaneo.robotpatternsample.presentation.BaseViewModel
import dev.marcocattaneo.robotpatternsample.presentation.Route
import dev.marcocattaneo.robotpatternsample.presentation.detail.RepoDetail
import dev.marcocattaneo.robotpatternsample.presentation.list.RepoList
import dev.marcocattaneo.robotpatternsample.presentation.state.VMState
import dev.marcocattaneo.robotpatternsample.presentation.welcome.WelcomeScreen
import dev.marcocattaneo.robotpatternsample.ui.theme.RobotPatternSampleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobotPatternSampleTheme {

                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(navController = navController, startDestination = Route.Welcome.path) {

                        composable(
                            route = Route.Welcome
                        ) {
                            WelcomeScreen(provideViewModel(navController))
                        }

                        composable(
                            route = Route.RepoList,
                            arguments = listOf(navArgument("username") { type = NavType.StringType })
                        ) { backStackEntry ->
                            RepoList(provideViewModel(navController), backStackEntry.arguments?.getString("username"))
                        }

                        composable(
                            route = Route.RepoDetail,
                            arguments = listOf(navArgument("id") { type = NavType.LongType })
                        ) { backStackEntry ->
                            RepoDetail(provideViewModel(navController), backStackEntry.arguments?.getLong("id"))
                        }

                    }
                }
            }
        }
    }

    @Composable
    private inline fun <VMS: VMState, reified VM : BaseViewModel<VMS>> provideViewModel(navHostController: NavHostController): VM {
        val vm = hiltViewModel<VM>()
        vm.registerNavHostController(navHostController = navHostController)
        return vm
    }

}