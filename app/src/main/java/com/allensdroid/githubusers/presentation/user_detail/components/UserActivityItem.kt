package com.allensdroid.githubusers.presentation.user_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.allensdroid.githubusers.domain.model.UserActivity

@Composable
fun UserActivityItem(
    activity: UserActivity
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Event Type: ${activity.type}",
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Actor DisplayName: ${activity.actorDisplayLogin}, Actor Login: ${activity.actorLogin}",
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            text = "Repo Name: ${activity.repoName}",
            style = MaterialTheme.typography.bodyMedium,
        )

        if (activity.payloadPushId != null) {
            Text(
                text = "Ref: ${activity.payloadRef}",
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                text = "HEAD: ${activity.payloadHead}",
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "BEFORE: ${activity.payloadBefore}",
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Text(
            text = "Commits (${activity.payloadCommits?.size ?: 0}) :",
            style = MaterialTheme.typography.bodyLarge,
        )

        if (!activity.payloadCommits.isNullOrEmpty()) {
            for (commit in activity.payloadCommits) {
                Text(
                    text = "Commit SHA: ${commit.sha}:",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Commit Message: ${commit.message}",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Commit Author Name: ${commit.authorName}",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}