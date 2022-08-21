package com.example.core.domain.model

sealed class GoalType(val name: String) {
    object GainWeight : GoalType("gain_weight")
    object LoseWeight : GoalType("lose_weight")
    object KeepWeight : GoalType("keep_weight")


    companion object {
        fun fromString(name: String) : GoalType {
            return when(name) {
                "gain_weight" -> GainWeight
                "lose_weight" -> LoseWeight
                "keep_weight" -> KeepWeight
                else -> LoseWeight
            }
        }
    }
}