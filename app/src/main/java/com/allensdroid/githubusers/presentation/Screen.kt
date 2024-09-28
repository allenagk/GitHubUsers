package com.allensdroid.githubusers.presentation

import kotlinx.serialization.Serializable

@Serializable
object GithubUserListScreen

@Serializable
data class GithubUserDetailScreen(val userName: String)