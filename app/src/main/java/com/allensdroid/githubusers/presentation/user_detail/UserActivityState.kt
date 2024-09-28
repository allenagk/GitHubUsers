package com.allensdroid.githubusers.presentation.user_detail

import com.allensdroid.githubusers.domain.model.UserActivity

data class UserActivityState(
    val isLoading: Boolean = false,
    val userActivities: List<UserActivity> = emptyList(),
    val error: String = ""
)