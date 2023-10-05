package com.muffar.daymeal.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.muffar.daymeal.domain.model.Meal
import com.muffar.daymeal.presentation.detail.component.DetailLoading
import com.muffar.daymeal.presentation.detail.component.IngredientContent
import com.muffar.daymeal.presentation.detail.component.InstructionContent
import com.muffar.daymeal.presentation.detail.component.MainInfoContent
import com.muffar.daymeal.presentation.detail.component.VideoContent
import com.muffar.daymeal.ui.common.RetryLoadData
import com.muffar.daymeal.ui.common.TabsWithSwiping

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    meal: Meal?,
    viewModel: DetailViewModel = hiltViewModel(),
    navigateUp: () -> Unit,
) {
    val state = viewModel.state.value
    val titles = listOf("Bahan", "Instruksi", "Video")

    LaunchedEffect(meal) {
        viewModel.getMealDetail(meal?.id ?: "")
    }

    Column(modifier = modifier) {
        if (state.isLoading) {
            DetailLoading()
        }

        if (state.isError) {
            RetryLoadData(
                errorMessage = state.errorMessage ?: "",
                modifier = Modifier.fillMaxSize(),
                onRetry = { viewModel.getMealDetail(meal?.id ?: "") }
            )
        }
        state.meal?.let { meal ->
            MainInfoContent(meal = meal, onBackPress = navigateUp)
            TabsWithSwiping(
                titles = titles
            ) { page ->
                when (page) {
                    0 -> IngredientContent(ingredients = meal.ingredients)
                    1 -> InstructionContent(instruction = meal.instructions)
                    2 -> VideoContent(videoId = meal.video?.split("v=")?.last() ?: "")
                }
            }
        }
    }
}