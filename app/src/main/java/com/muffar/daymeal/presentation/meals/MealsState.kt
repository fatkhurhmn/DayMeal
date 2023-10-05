package com.muffar.daymeal.presentation.meals

import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.domain.model.Meal

data class MealsState(
    val meals: List<Meal>? = null,
    val category: Category? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null,
)
