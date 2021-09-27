package dev.marcocattaneo.robotpatternsample.presentation.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import dev.marcocattaneo.robotpatternsample.ui.theme.Dimen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ScreenContainer(
    baseViewModel: BaseViewModel,
    content: @Composable ColumnScope.() -> Unit
) {
    val uiErrorState by baseViewModel.uiErrorState.collectAsState()

    Box {
        uiErrorState?.let {
            Card(
                elevation = Dimen.DefaultElevation,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimen.Large),
                backgroundColor = MaterialTheme.colors.primary,
                onClick = {
                    baseViewModel.dismissError()
                }
            ) {
                Text(
                    modifier = Modifier.padding(Dimen.Normal),
                    text = it.format(),
                    color = MaterialTheme.colors.background
                )
            }
        }
        Column(
            content = content,
            modifier = Modifier.padding(Dimen.Large)
        )
    }
}