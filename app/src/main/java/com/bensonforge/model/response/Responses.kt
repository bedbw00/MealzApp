package com.bensonforge.model.response

import android.app.ActivityManager.TaskDescription
import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(val categories: List<MealResponse>)


data class MealResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageURL: String
)
