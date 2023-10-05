package com.muffar.daymeal.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.domain.model.Meal
import com.muffar.daymeal.presentation.categories.CategoriesScreen
import com.muffar.daymeal.presentation.detail.DetailScreen
import com.muffar.daymeal.presentation.meals.MealsScreen
import com.muffar.daymeal.utils.Constants

@Composable
fun MainNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        route = Constants.MAIN_GRAPH,
        startDestination = Screen.Categories.route
    ) {
        composable(route = Screen.Categories.route) {
            CategoriesScreen(
                navigateToMeals = { category ->
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        Constants.CATEGORY_KEY,
                        category
                    )
                    navController.navigate(Screen.Meals.route)
                }
            )
        }

        composable(route = Screen.Meals.route) {
            navController.previousBackStackEntry?.savedStateHandle?.get<Category>(Constants.CATEGORY_KEY)
                ?.let { category ->
                    MealsScreen(
                        category = category,
                        navigateToDetail = { meal ->
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                Constants.MEAL_KEY,
                                meal
                            )
                            navController.navigate(Screen.Detail.route)
                        },
                        navigateUp = { navController.popBackStack() }
                    )
                }
        }

        composable(route = Screen.Detail.route) {
            navController.previousBackStackEntry?.savedStateHandle?.get<Meal>(Constants.MEAL_KEY)
                .let { meal ->
                    DetailScreen(
                        meal = meal,
                        navigateUp = { navController.popBackStack() }
                    )
                }
        }
    }
}