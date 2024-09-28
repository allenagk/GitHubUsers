package com.allensdroid.githubusers.domain.model

data class UserActivity(
    val id: String,
    val type: String,
    val actorLogin: String,
    val actorDisplayLogin: String,
    val repoName: String,
    val payloadPushId: Long?,
    val payloadSize: Int?,
    val payloadHead: String?,
    val payloadRef: String?,
    val payloadBefore: String?,
    val payloadCommits: List<Commit>?
)

data class Commit(
    val sha: String,
    val message: String,
    val authorName: String,
    val authorEmail: String
)