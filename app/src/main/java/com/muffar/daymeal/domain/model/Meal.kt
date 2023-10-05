package com.muffar.daymeal.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    val id: String? = "",
    val name: String? = "",
    val category: String? = "",
    val instructions: String? = "",
    val area: String? = "",
    val image: String? = "",
    val video: String? = "",
    val ingredients: List<Ingredient>? = emptyList(),
    val tags: List<String>? = emptyList(),
) : Parcelable