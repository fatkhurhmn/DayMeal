package com.muffar.daymeal.ui.navigation

sealed class Screen(val route: String) {

    object Categories : Screen("categories")
    object Meals : Screen("meals")
    object Detail : Screen("object")
}