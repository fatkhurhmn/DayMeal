package com.muffar.daymeal.presentation.meals

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.muffar.daymeal.domain.model.Category

@Composable
fun MealsScreen(
    category: Category,
    modifier: Modifier = Modifier,
    viewModel: MealsViewModel = hiltViewModel(),
) {

    LaunchedEffect(category) {
        viewModel.getMealsByCategory(category.name)
    }
}