package com.allensdroid.githubusers.data.repository

import com.allensdroid.githubusers.data.remote.GiHubApi
import com.allensdroid.githubusers.data.remote.dto.UserActivityDto
import com.allensdroid.githubusers.data.remote.dto.UserDetailDto
import com.allensdroid.githubusers.data.remote.dto.UserDto
import com.allensdroid.githubusers.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val api: GiHubApi
) : GithubRepository {

    override suspend fun getUsers(): List<UserDto> {
        return api.getUsers()
    }

    override suspend fun getUserDetail(username: String): UserDetailDto {
        return api.getUserByUserName(username)
    }

    override suspend fun getUserActivities(username: String): List<UserActivityDto> {
        return api.getUserActivities(username)
    }
}