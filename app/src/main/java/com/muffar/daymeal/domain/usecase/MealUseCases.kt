package com.muffar.daymeal.domain.usecase

data class MealUseCases(
    val getCategories: GetCategories,
    val getMealsByCategory: GetMealsByCategory,
    val getMealDetail: GetMealDetail,
)
