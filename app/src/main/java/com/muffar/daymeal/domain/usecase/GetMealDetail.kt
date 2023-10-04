package com.muffar.daymeal.domain.usecase

import com.muffar.daymeal.data.Resource
import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.domain.model.Meal
import com.muffar.daymeal.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow

class GetMealDetail(
    private val mealRepository: MealRepository,
) {
    suspend operator fun invoke(id: String): Flow<Resource<Meal>> =
        mealRepository.getMealDetail(id)
}