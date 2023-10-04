package com.muffar.daymeal.data.remote

import com.muffar.daymeal.data.remote.response.CategoriesResponse
import com.muffar.daymeal.data.remote.response.MealsDetailResponse
import com.muffar.daymeal.data.remote.response.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

    @GET("filter.php")
    suspend fun getMealsByCategory(
        @Query("c") category: String,
    ): MealsResponse

    @GET("lookup.php")
    suspend fun getMealDetail(
        @Query("i") mealId: String,
    ): MealsDetailResponse
}