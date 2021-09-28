package dev.marcocattaneo.robotpatternsample.presentation.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.marcocattaneo.robotpatternsample.R
import dev.marcocattaneo.robotpatternsample.ui.theme.Dimen

@Composable
fun WelcomeScreen(welcomeViewModel: WelcomeViewModel) {
    val uiState by welcomeViewModel.uiState.collectAsState()

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = Dimen.DefaultElevation
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState?.username ?: "",
                onValueChange = welcomeViewModel::onChangeUsername,
                placeholder = {
                    Text(text = stringResource(id = R.string.welcome_username_hint))
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = welcomeViewModel::confirm,
                enabled = uiState?.valid == true
            ) {
                Text(text = stringResource(id = R.string.welcome_confirm_button))
            }
        }
    }
}