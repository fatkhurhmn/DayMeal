package com.muffar.daymeal.presentation.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.presentation.categories.components.CategoriesHeader
import com.muffar.daymeal.presentation.categories.components.CategoriesListContent
import com.muffar.daymeal.presentation.categories.components.CategoriesLoading
import com.muffar.daymeal.ui.common.EmptyListMessage
import com.muffar.daymeal.ui.common.RetryLoadData

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    viewModel: CategoriesViewModel = hiltViewModel(),
    navigateToMeals: (Category) -> Unit,
) {
    val state = viewModel.state.value

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        CategoriesHeader(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        if (state.isLoading) {
            CategoriesLoading()
        }

        if (state.isError) {
            RetryLoadData(
                errorMessage = state.errorMessage ?: "",
                modifier = Modifier.fillMaxSize(),
                onRetry = { viewModel.getCategories() }
            )
        }

        state.categories?.let {
            if (state.categories.isNotEmpty()) {
                CategoriesListContent(
                    categories = state.categories,
                    onClick = { navigateToMeals(it) }
                )
            } else {
                EmptyListMessage(modifier = Modifier.fillMaxSize())
            }
        }
    }
}