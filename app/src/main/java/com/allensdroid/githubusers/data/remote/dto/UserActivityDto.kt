package com.allensdroid.githubusers.data.remote.dto

import com.allensdroid.githubusers.domain.model.Commit
import com.allensdroid.githubusers.domain.model.UserActivity

data class UserActivityDto(
    val id: String,
    val type: String,
    val actor: ActorDto,
    val repo: RepoDto,
    val payload: PayloadDto,
)

data class ActorDto(
    val id: Int,
    val login: String,
    val display_login: String,
)

data class RepoDto(
    val id: Int,
    val name: String,
)

data class PayloadDto(
    val push_id: Long?,
    val size: Int?,
    val head: String?,
    val ref: String?,
    val before: String?,
    val commits: List<CommitDto>?,
)

data class CommitDto(
    val sha: String,
    val message: String,
    val author: AuthorDto,
)

data class AuthorDto(
    val name: String,
    val email: String,
)

fun UserActivityDto.toUserActivity(): UserActivity {
    return UserActivity(
        id = id,
        type = type,
        actorLogin = actor.login,
        actorDisplayLogin = actor.display_login,
        repoName = repo.name,
        payloadPushId = payload.push_id,
        payloadSize = payload.size,
        payloadHead = payload.head,
        payloadRef = payload.ref,
        payloadBefore = payload.before,
        payloadCommits = payload.commits?.map { it.toCommit() }
    )
}

fun CommitDto.toCommit(): Commit {
    return Commit(
        sha = sha,
        message = message,
        authorName = author.name,
        authorEmail = author.email,
    )
}