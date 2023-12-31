package com.muffar.daymeal.data.repository

import com.muffar.daymeal.data.Resource
import com.muffar.daymeal.data.remote.MealApi
import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.domain.model.Meal
import com.muffar.daymeal.domain.repository.MealRepository
import com.muffar.daymeal.utils.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MealRepositoryImpl(
    private val mealApi: MealApi,
) : MealRepository {
    override suspend fun getCategories(): Flow<Resource<List<Category>>> = flow {
        emit(Resource.Loading)
        try {
            val response = mealApi.getCategories()
            val categories = response.categories.map {
                DataMapper.mapCategoriesResponseToCategory(it)
            }.sortedBy { it.name }
            emit(Resource.Success(categories))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: ""))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getMealsByCategory(category: String): Flow<Resource<List<Meal>>> = flow {
        emit(Resource.Loading)
        try {
            val response = mealApi.getMealsByCategory(category)
            val meals = response.meals.map {
                DataMapper.mapMealResponseToMeal(it)
            }
            emit(Resource.Success(meals))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: ""))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getMealDetail(id: String): Flow<Resource<Meal>> = flow {
        emit(Resource.Loading)
        try {
            val response = mealApi.getMealDetail(id)
            val meal = DataMapper.mapMealResponseToMeal(response.meals[0])
            emit(Resource.Success(meal))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: ""))
        }
    }.flowOn(Dispatchers.IO)
}