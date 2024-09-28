package com.allensdroid.githubusers.domain.use_case.get_user

import com.allensdroid.githubusers.common.Resource
import com.allensdroid.githubusers.data.remote.dto.toUserDetail
import com.allensdroid.githubusers.domain.model.UserDetail
import com.allensdroid.githubusers.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: GithubRepository
) {
    operator fun invoke(userName: String): Flow<Resource<UserDetail>> = flow {
        try {
            emit(Resource.Loading())
            val user = repository.getUserDetail(userName).toUserDetail()
            emit(Resource.Success(user))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}