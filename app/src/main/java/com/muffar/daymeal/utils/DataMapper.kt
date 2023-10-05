package com.muffar.daymeal.utils

import com.muffar.daymeal.data.remote.response.CategoryItemResponse
import com.muffar.daymeal.data.remote.response.MealItemResponse
import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.domain.model.Ingredient
import com.muffar.daymeal.domain.model.Meal

object DataMapper {
    fun mapCategoriesResponseToCategory(value: CategoryItemResponse): Category =
        Category(
            id = value.idCategory,
            name = value.strCategory,
            description = value.strCategoryDescription,
            image = value.strCategoryThumb
        )

    fun mapMealResponseToMeal(value: MealItemResponse): Meal {
        val ingredients = listOf(
            Ingredient(ingredient = value.strIngredient1, measure = value.strMeasure1),
            Ingredient(ingredient = value.strIngredient2, measure = value.strMeasure2),
            Ingredient(ingredient = value.strIngredient3, measure = value.strMeasure3),
            Ingredient(ingredient = value.strIngredient4, measure = value.strMeasure4),
            Ingredient(ingredient = value.strIngredient5, measure = value.strMeasure5),
            Ingredient(ingredient = value.strIngredient6, measure = value.strMeasure6),
            Ingredient(ingredient = value.strIngredient7, measure = value.strMeasure7),
            Ingredient(ingredient = value.strIngredient8, measure = value.strMeasure8),
            Ingredient(ingredient = value.strIngredient9, measure = value.strMeasure9),
            Ingredient(ingredient = value.strIngredient10, measure = value.strMeasure10),
            Ingredient(ingredient = value.strIngredient11, measure = value.strMeasure11),
            Ingredient(ingredient = value.strIngredient12, measure = value.strMeasure12),
            Ingredient(ingredient = value.strIngredient13, measure = value.strMeasure13),
            Ingredient(ingredient = value.strIngredient14, measure = value.strMeasure14),
            Ingredient(ingredient = value.strIngredient15, measure = value.strMeasure15),
            Ingredient(ingredient = value.strIngredient16, measure = value.strMeasure16),
            Ingredient(ingredient = value.strIngredient17, measure = value.strMeasure17),
            Ingredient(ingredient = value.strIngredient18, measure = value.strMeasure18),
            Ingredient(ingredient = value.strIngredient19, measure = value.strMeasure19),
            Ingredient(ingredient = value.strIngredient20, measure = value.strMeasure20),
        )
        return Meal(
            id = value.idMeal,
            name = value.strMeal,
            category = value.strCategory,
            instructions = value.strInstructions,
            area = value.strArea,
            image = value.strMealThumb,
            video = value.strYoutube,
            ingredients = ingredients,
            tags = value.strTags?.split(",")
        )
    }
}