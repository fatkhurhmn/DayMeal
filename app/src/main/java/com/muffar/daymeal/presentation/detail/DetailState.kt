package com.muffar.daymeal.presentation.detail

import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.domain.model.Meal

data class DetailState(
    val meal: Meal? = null,
    val category: Category,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null,
)
