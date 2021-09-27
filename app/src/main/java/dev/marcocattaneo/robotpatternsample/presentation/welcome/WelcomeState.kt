package dev.marcocattaneo.robotpatternsample.presentation.welcome

import dev.marcocattaneo.robotpatternsample.presentation.state.VMState

data class WelcomeState(
    val username: String = ""
): VMState() {
    val valid: Boolean
        get() = username.isNotEmpty()
}