package com.muffar.daymeal.domain.usecase

import com.muffar.daymeal.data.Resource
import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow

class GetCategories(
    private val mealRepository: MealRepository,
) {
    suspend operator fun invoke(): Flow<Resource<List<Category>>> =
        mealRepository.getCategories()
}