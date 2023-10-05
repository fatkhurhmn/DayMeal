package com.muffar.daymeal.presentation.meals.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.domain.model.Meal

@Composable
fun MealsListContent(
    meals: List<Meal>,
    onClick: (Meal) -> Unit,
    category: Category,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        item(
            span = { GridItemSpan(this.maxLineSpan) }
        ) {
            MealsHeader(
                category = category,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        items(meals) { meal ->
            MealsItem(
                meal = meal,
                onClick = { onClick(meal) }
            )
        }
    }
}