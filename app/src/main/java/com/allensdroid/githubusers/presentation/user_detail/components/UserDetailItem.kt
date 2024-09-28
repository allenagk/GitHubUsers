package com.allensdroid.githubusers.presentation.user_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.allensdroid.githubusers.domain.model.UserActivity
import com.allensdroid.githubusers.domain.model.UserDetail

@Composable
fun UserDetailItem(
    user: UserDetail,
    userActivities: List<UserActivity>,
    innerPadding: PaddingValues,
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            AsyncImage(
                model = user.avatarUrl,
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = user.name ?: "-",
                    style = MaterialTheme.typography.headlineSmall,
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = user.company ?: "-",
                    style = MaterialTheme.typography.bodyMedium,
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = user.location ?: "-",
                    style = MaterialTheme.typography.bodyMedium,
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = user.bio ?: "-",
                    style = MaterialTheme.typography.bodyMedium,
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Followers: ${user.followers ?: 0} | Following: ${user.following ?: 0}",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }

        HorizontalDivider()

        Text(
            text = "User Activities",
            style = MaterialTheme.typography.headlineSmall,
        )

        if (userActivities.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "No Activities Found",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
        }

        LazyColumn {
            items(userActivities.size) { index ->
                UserActivityItem(activity = userActivities[index])
                HorizontalDivider(Modifier.padding(top = 4.dp, bottom = 4.dp))
            }
        }
    }
}