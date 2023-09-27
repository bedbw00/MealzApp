package com.bensonforge.model

import com.bensonforge.model.api.MealsWebService
import com.bensonforge.model.response.MealResponse
import com.bensonforge.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    private var cachedMeals = arrayListOf<MealResponse>()

    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories as ArrayList<MealResponse>
        return response

    }

    fun getMeal(id: String): MealResponse? {
        return cachedMeals.firstOrNull() {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance?: MealsRepository().also { instance = it }
        }
    }

}