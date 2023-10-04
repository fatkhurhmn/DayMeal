package com.muffar.daymeal.presentation.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muffar.daymeal.presentation.category.components.CategoryHeader
import com.muffar.daymeal.presentation.category.components.CategoryListContent
import com.muffar.daymeal.presentation.category.components.CategoryLoading
import com.muffar.daymeal.ui.common.EmptyListMessage
import com.muffar.daymeal.ui.common.RetryLoadData

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    viewModel: CategoryViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        CategoryHeader(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        if (state.isLoading) {
            CategoryLoading()
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
                CategoryListContent(categories = state.categories)
            } else {
                EmptyListMessage(modifier = Modifier.fillMaxSize())
            }
        }
    }
}