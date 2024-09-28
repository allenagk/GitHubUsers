package com.allensdroid.githubusers.presentation.user_list

import com.allensdroid.githubusers.domain.model.User

data class UserListState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)