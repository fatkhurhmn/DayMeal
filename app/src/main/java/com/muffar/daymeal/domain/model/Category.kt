package com.muffar.daymeal.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
) : Parcelable