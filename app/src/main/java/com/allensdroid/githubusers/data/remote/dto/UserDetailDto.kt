package com.allensdroid.githubusers.data.remote.dto

import com.allensdroid.githubusers.domain.model.UserDetail
import com.google.gson.annotations.SerializedName

data class UserDetailDto(
    val name: String?,
    val followers: Int?,
    val following: Int?,
    @SerializedName("avatar_url") val avatarUrl: String?,
    val email: String?,
    val bio: String?,
    val company: String?,
    val location: String?,
)

fun UserDetailDto.toUserDetail(): UserDetail {
    return UserDetail(
        name = name,
        followers = followers,
        following = following,
        avatarUrl = avatarUrl,
        email = email,
        bio = bio,
        company = company,
        location = location,
    )
}