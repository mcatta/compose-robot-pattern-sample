package dev.marcocattaneo.robotpatternsample.presentation.state

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

data class ErrorState(@StringRes val resourceErrorMessage: Int) {

    @Composable
    fun format(): String {
        return stringResource(id = resourceErrorMessage)
    }
}