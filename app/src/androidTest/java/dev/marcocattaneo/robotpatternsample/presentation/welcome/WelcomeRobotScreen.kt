package dev.marcocattaneo.robotpatternsample.presentation.welcome

import androidx.compose.ui.test.*
import dev.marcocattaneo.robotpatternsample.BaseAndroidComposeTest
import dev.marcocattaneo.robotpatternsample.R
import dev.marcocattaneo.robotpatternsample.presentation.list.RepoListRobotScreen
import dev.marcocattaneo.robotpatternsample.presentation.list.repoListRobotScreen
import dev.marcocattaneo.robotpatternsample.robot.BaseRobotScreen

internal fun BaseAndroidComposeTest.welcomeRobotScreen(
    func: WelcomeRobotScreen.() -> Unit
) = WelcomeRobotScreen(this).apply(func)

internal class WelcomeRobotScreen(
    private val baseAndroidComposeTest: BaseAndroidComposeTest
) : BaseRobotScreen(
    baseAndroidComposeTest.composeTestRule
) {

    private val usernameField by lazy { composeTestRule.onNode(hasText(getString(R.string.welcome_username_hint))) }

    private val confirmButton by lazy { composeTestRule.onNode(hasText(getString(R.string.welcome_confirm_button))) }

    fun typeUsername(username: String) = usernameField.performTextReplacement(username)

    fun isConfirmEnabled(enabled: Boolean) = confirmButton.assert(
        if (enabled) isEnabled() else isEnabled().not()
    )

    infix fun confirmUsername(func: RepoListRobotScreen.() -> Unit): RepoListRobotScreen {
        confirmButton.performClick()
        return baseAndroidComposeTest.repoListRobotScreen(func = func)
    }

}