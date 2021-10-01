package dev.marcocattaneo.robotpatternsample.robot

import androidx.annotation.StringRes
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import dev.marcocattaneo.robotpatternsample.MainActivity

internal abstract class BaseRobotScreen constructor(
    protected val composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {

    protected fun getString(@StringRes resourceId: Int) =
        composeTestRule.activity.getString(resourceId)

}