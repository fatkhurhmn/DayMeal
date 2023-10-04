package com.muffar.daymeal.domain.repository

import com.muffar.daymeal.data.Resource
import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    suspend fun getCategories(): Flow<Resource<List<Category>>>
    suspend fun getMealsByCategory(category: String): Flow<Resource<List<Meal>>>
    suspend fun getMealDetail(id: String): Flow<Resource<Meal>>
}