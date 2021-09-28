package dev.marcocattaneo.robotpatternsample.ui.ds

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.marcocattaneo.robotpatternsample.ui.theme.Dimen

@Composable
fun Header(
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .padding(Dimen.Large)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = title,
            modifier = Modifier.padding(end = Dimen.Large)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.h5
        )
    }
}

@Composable
@Preview
fun HeaderPreview() {
    Header(title = "Sample title")
}