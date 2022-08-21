package com.example.core.domain

import android.content.SharedPreferences
import com.example.core.domain.model.ActivityLevel
import com.example.core.domain.model.Gender
import com.example.core.domain.model.GoalType
import com.example.core.domain.model.UserInfo
import com.example.core.domain.preferences.Preferences
import com.example.core.domain.preferences.Preferences.Companion.AGE_KEY
import com.example.core.domain.preferences.Preferences.Companion.GENDER_KEY
import com.example.core.domain.preferences.Preferences.Companion.KEY_ACTIVITY_LEVEL
import com.example.core.domain.preferences.Preferences.Companion.KEY_CARB_RATIO
import com.example.core.domain.preferences.Preferences.Companion.KEY_FAT_RATIO
import com.example.core.domain.preferences.Preferences.Companion.KEY_GOAL_TYPE
import com.example.core.domain.preferences.Preferences.Companion.KEY_HEIGHT
import com.example.core.domain.preferences.Preferences.Companion.KEY_PROTEIN_RATIO
import com.example.core.domain.preferences.Preferences.Companion.KEY_WEIGHT

class DefaultPreferences(private val sharedPreferences: SharedPreferences) : Preferences {

    override fun saveGender(gender: Gender) {
        sharedPreferences.edit()
            .putString(GENDER_KEY, gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharedPreferences.edit()
            .putInt(AGE_KEY, age)
            .apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPreferences.edit()
            .putFloat(KEY_WEIGHT, weight)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharedPreferences.edit()
            .putInt(KEY_HEIGHT, height)
            .apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharedPreferences.edit()
            .putString(KEY_ACTIVITY_LEVEL, level.name)
            .apply()
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPreferences.edit()
            .putString(KEY_GOAL_TYPE, goalType.name)
            .apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPreferences.edit()
            .putFloat(KEY_CARB_RATIO, ratio)
            .apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPreferences.edit()
            .putFloat(KEY_PROTEIN_RATIO, ratio)
            .apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPreferences.edit()
            .putFloat(KEY_FAT_RATIO, ratio)
            .apply()
    }

    override fun loadInfo(): UserInfo {
        val age = sharedPreferences.getInt(AGE_KEY, -1)
        val height = sharedPreferences.getInt(KEY_HEIGHT, -1)
        val weight = sharedPreferences.getFloat(KEY_WEIGHT, -1f)
        val genderString = sharedPreferences.getString(GENDER_KEY, null)
        val activityLevelString = sharedPreferences
            .getString(KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPreferences.getString(KEY_GOAL_TYPE, null)
        val carbRatio = sharedPreferences.getFloat(KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPreferences.getFloat(KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPreferences.getFloat(KEY_FAT_RATIO, -1f)

        return UserInfo(
            gender = Gender.fromString(genderString ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevelString ?: "medium"),
            goalType = GoalType.fromString(goalType ?: "keep_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )

    }
}