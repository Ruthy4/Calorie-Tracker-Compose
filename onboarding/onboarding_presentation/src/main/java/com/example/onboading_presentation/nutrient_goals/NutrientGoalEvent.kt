package com.example.onboading_presentation.nutrient_goals

sealed class NutrientGoalEvent {
    data class OnCarbRatioEnter(val ratio : String) : NutrientGoalEvent()
    data class OnProteinRatioEnter(val ratio : String) : NutrientGoalEvent()
    data class OnFatRatioEnter(val ratio : String) : NutrientGoalEvent()

    object OnNextClicked : NutrientGoalEvent()
}
