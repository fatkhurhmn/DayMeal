package com.muffar.daymeal.presentation.category

import com.muffar.daymeal.domain.model.Category

data class CategoryState(
    val categories: List<Category>? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null,
)
