package com.allensdroid.githubusers.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.allensdroid.githubusers.presentation.ui.theme.GitHubUsersTheme
import com.allensdroid.githubusers.presentation.user_detail.UserDetailScreen
import com.allensdroid.githubusers.presentation.user_list.UserListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitHubUsersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = GithubUserListScreen
                    ) {
                        composable<GithubUserListScreen> {
                            UserListScreen(navController)
                        }
                        composable<GithubUserDetailScreen> {
                            val detailScreenData = it.toRoute<GithubUserDetailScreen>()
                            UserDetailScreen(navController, detailScreenData.userName)
                        }
                    }
                }
            }
        }
    }
}