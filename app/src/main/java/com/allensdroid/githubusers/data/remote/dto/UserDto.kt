package com.allensdroid.githubusers.data.remote.dto

import com.allensdroid.githubusers.domain.model.User
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("login") val username: String,
    @SerializedName("avatar_url") val avatarUrl: String
)

fun UserDto.toUser(): User {
    return User(username, avatarUrl)
}