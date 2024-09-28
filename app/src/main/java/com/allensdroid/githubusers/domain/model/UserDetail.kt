package com.allensdroid.githubusers.domain.model

data class UserDetail(
    val name: String?,
    val followers: Int?,
    val following: Int?,
    val avatarUrl: String?,
    val bio: String?,
    val company: String?,
    val email: String?,
    val location: String?,
)