package com.allensdroid.githubusers.presentation.user_detail

import com.allensdroid.githubusers.domain.model.UserDetail

data class UserDetailState(
    val isLoading: Boolean = false,
    val userDetail: UserDetail? = null,
    val error: String = ""
)