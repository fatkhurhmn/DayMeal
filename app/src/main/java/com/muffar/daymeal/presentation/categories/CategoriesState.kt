package com.muffar.daymeal.presentation.categories

import com.muffar.daymeal.domain.model.Category

data class CategoriesState(
    val categories: List<Category>? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null,
)
