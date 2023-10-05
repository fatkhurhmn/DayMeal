package com.muffar.daymeal.presentation.categories.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.muffar.daymeal.R

@Composable
fun CategoriesHeader(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.hai_meallover),
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.inversePrimary
        )
        Text(
            text = stringResource(R.string.welcome),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}