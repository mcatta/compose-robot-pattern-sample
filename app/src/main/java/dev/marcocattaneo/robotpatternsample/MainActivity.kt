package dev.marcocattaneo.robotpatternsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import dev.marcocattaneo.robotpatternsample.presentation.Route
import dev.marcocattaneo.robotpatternsample.presentation.detail.RepoDetail
import dev.marcocattaneo.robotpatternsample.presentation.detail.RepoDetailViewModel
import dev.marcocattaneo.robotpatternsample.presentation.list.RepoList
import dev.marcocattaneo.robotpatternsample.presentation.list.RepoListViewModel
import dev.marcocattaneo.robotpatternsample.presentation.welcome.WelcomeScreen
import dev.marcocattaneo.robotpatternsample.presentation.welcome.WelcomeViewModel
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

                        composable<WelcomeViewModel>(
                            navHostController = navController,
                            route = Route.Welcome
                        ) { _, vm ->
                            WelcomeScreen(vm)
                        }

                        composable<RepoListViewModel>(
                            route = Route.RepoList(""),
                            navHostController = navController,
                            arguments = listOf(navArgument("username") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry, vm ->
                            RepoList(vm, backStackEntry.arguments?.getString("username"))
                        }

                        composable<RepoDetailViewModel>(
                            route = Route.RepoDetail(-1),
                            navHostController = navController,
                            arguments = listOf(navArgument("id") { type = NavType.LongType })
                        ) { backStackEntry, vm ->
                            RepoDetail(vm, backStackEntry.arguments?.getLong("id"))
                        }

                    }
                }
            }
        }
    }

}