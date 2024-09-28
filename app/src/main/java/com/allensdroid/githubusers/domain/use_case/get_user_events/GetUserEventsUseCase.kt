package com.allensdroid.githubusers.domain.use_case.get_user_events

import com.allensdroid.githubusers.common.Resource
import com.allensdroid.githubusers.data.remote.dto.toUserActivity
import com.allensdroid.githubusers.domain.model.UserActivity
import com.allensdroid.githubusers.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserEventsUseCase @Inject constructor(
    private val repository: GithubRepository
) {
    operator fun invoke(userName: String): Flow<Resource<List<UserActivity>>> = flow {
        try {
            emit(Resource.Loading())
            val activities = repository.getUserActivities(userName).map { it.toUserActivity() }
            emit(Resource.Success(activities))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}