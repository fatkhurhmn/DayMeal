package com.muffar.daymeal.di

import com.muffar.daymeal.data.remote.MealApi
import com.muffar.daymeal.data.repository.MealRepositoryImpl
import com.muffar.daymeal.domain.repository.MealRepository
import com.muffar.daymeal.domain.usecase.GetCategories
import com.muffar.daymeal.domain.usecase.GetMealDetail
import com.muffar.daymeal.domain.usecase.GetMealsByCategory
import com.muffar.daymeal.domain.usecase.MealUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMealRepository(
        mealApi: MealApi,
    ): MealRepository = MealRepositoryImpl(mealApi)

    @Provides
    fun provideMealUseCases(
        mealRepository: MealRepository,
    ): MealUseCases =
        MealUseCases(
            getCategories = GetCategories(mealRepository),
            getMealsByCategory = GetMealsByCategory(mealRepository),
            getMealDetail = GetMealDetail(mealRepository)
        )
}