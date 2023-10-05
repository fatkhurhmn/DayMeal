package com.muffar.daymeal.presentation.categories.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.muffar.daymeal.R
import com.muffar.daymeal.domain.model.Category

@Composable
fun CategoriesListContent(
    categories: List<Category>,
    onClick: (Category) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        item(
            span = { GridItemSpan(this.maxLineSpan) }
        ) {
            Text(
                text = stringResource(R.string.category),
                style = MaterialTheme.typography.titleLarge,
            )
        }
        items(categories) { category ->
            CategoriesItem(
                category = category,
                onClick = { onClick(category) }
            )
        }
    }
}