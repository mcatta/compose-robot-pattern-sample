package dev.marcocattaneo.robotpatternsample.presentation.list

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasTestTag
import dev.marcocattaneo.robotpatternsample.BaseAndroidComposeTest
import dev.marcocattaneo.robotpatternsample.robot.BaseRobotScreen

internal fun BaseAndroidComposeTest.repoListRobotScreen(
    func: RepoListRobotScreen.() -> Unit
) = RepoListRobotScreen(this).also(func)

internal class RepoListRobotScreen(
    baseAndroidComposeTest: BaseAndroidComposeTest
) : BaseRobotScreen(
    composeTestRule = baseAndroidComposeTest.composeTestRule
) {

    fun countRepositories(count: Int) {
        composeTestRule.onAllNodes(
            hasTestTag("repoItem")
        ).assertCountEquals(count)
    }

}