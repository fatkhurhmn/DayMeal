package com.muffar.daymeal.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingredient(
    val ingredient: String? = "",
    val measure: String? = "",
):Parcelable
