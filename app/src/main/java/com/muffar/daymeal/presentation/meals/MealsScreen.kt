package com.muffar.daymeal.presentation.meals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.domain.model.Meal
import com.muffar.daymeal.presentation.meals.components.MealsListContent
import com.muffar.daymeal.presentation.meals.components.MealsLoading
import com.muffar.daymeal.ui.common.EmptyListMessage
import com.muffar.daymeal.ui.common.MainScaffold
import com.muffar.daymeal.ui.common.RetryLoadData

@Composable
fun MealsScreen(
    category: Category,
    modifier: Modifier = Modifier,
    navigateToDetail: (Meal) -> Unit,
    navigateUp: () -> Unit,
    viewModel: MealsViewModel = hiltViewModel(),
) {

    val state = viewModel.state.value

    LaunchedEffect(category) {
        viewModel.getMealsByCategory(category.name)
    }

    MainScaffold(
        titleAppBar = category.name,
        showBackNavigation = true,
        onBackNavigationClick = navigateUp,
    ) {
        Column(modifier = modifier) {
            if (state.isLoading) {
                MealsLoading(category)
            }

            if (state.isError) {
                RetryLoadData(
                    errorMessage = state.errorMessage ?: "",
                    modifier = Modifier.fillMaxSize(),
                    onRetry = { viewModel.getMealsByCategory(category.name) }
                )
            }

            state.meals?.let {
                if (state.meals.isNotEmpty()) {
                    MealsListContent(
                        meals = state.meals,
                        onClick = { navigateToDetail(it)},
                        category = category
                    )
                } else {
                    EmptyListMessage(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}