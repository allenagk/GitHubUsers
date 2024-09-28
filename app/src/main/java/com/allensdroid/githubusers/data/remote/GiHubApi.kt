package com.allensdroid.githubusers.data.remote

import com.allensdroid.githubusers.data.remote.dto.UserActivityDto
import com.allensdroid.githubusers.data.remote.dto.UserDetailDto
import com.allensdroid.githubusers.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GiHubApi {

    @GET("users")
    suspend fun getUsers(
    ): List<UserDto>

    @GET("users/{user_name}")
    suspend fun getUserByUserName(
        @Path("user_name") id: String
    ): UserDetailDto

    @GET("users/{user_name}/events")
    suspend fun getUserActivities(
        @Path("user_name") id: String
    ): List<UserActivityDto>
}