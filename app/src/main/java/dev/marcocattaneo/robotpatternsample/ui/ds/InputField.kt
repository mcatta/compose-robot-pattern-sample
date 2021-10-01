package dev.marcocattaneo.robotpatternsample.ui.ds

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    OutlinedTextField(
        modifier = modifier.semantics { contentDescription = placeholder },
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeholder)
        }
    )
}