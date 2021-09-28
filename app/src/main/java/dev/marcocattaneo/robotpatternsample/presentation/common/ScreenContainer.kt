package dev.marcocattaneo.robotpatternsample.presentation.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.marcocattaneo.robotpatternsample.ui.ds.Header
import dev.marcocattaneo.robotpatternsample.ui.theme.Dimen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ScreenContainer(
    baseViewModel: BaseViewModel,
    content: @Composable ColumnScope.() -> Unit
) {
    val uiErrorState by baseViewModel.uiErrorState.collectAsState()

    Box {
        Header(
            modifier = Modifier.align(Alignment.TopStart),
            title = baseViewModel.getSectionHeaderTitle()
        )
        uiErrorState?.let {
            Card(
                elevation = Dimen.DefaultElevation,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimen.Large),
                backgroundColor = MaterialTheme.colors.error,
                onClick = {
                    baseViewModel.dismissError()
                }
            ) {
                Text(
                    modifier = Modifier.padding(Dimen.Normal),
                    text = it.format(),
                    color = MaterialTheme.colors.onError
                )
            }
        }
        Column(
            content = content,
            modifier = Modifier
                .padding(
                    top = 64.dp,    // Workaround, the best practice should be to use ConstraintLayout
                    start = Dimen.Large,
                    end = Dimen.Large,
                    bottom = Dimen.Large
                )
        )
    }
}