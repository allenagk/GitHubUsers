package com.allensdroid.githubusers.domain.repository

import com.allensdroid.githubusers.data.remote.dto.UserActivityDto
import com.allensdroid.githubusers.data.remote.dto.UserDetailDto
import com.allensdroid.githubusers.data.remote.dto.UserDto

interface GithubRepository {

    suspend fun getUsers(): List<UserDto>

    suspend fun getUserDetail(username: String): UserDetailDto

    suspend fun getUserActivities(username: String): List<UserActivityDto>

}