package com.allensdroid.githubusers.presentation.user_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.allensdroid.githubusers.common.Constants
import com.allensdroid.githubusers.common.Resource
import com.allensdroid.githubusers.domain.use_case.get_user.GetUserUseCase
import com.allensdroid.githubusers.domain.use_case.get_user_events.GetUserEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getUserEventsUseCase: GetUserEventsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(UserDetailState())
    val state: State<UserDetailState> = _state

    private val _activityState = mutableStateOf(UserActivityState())
    val activityState: State<UserActivityState> = _activityState

    init {
        savedStateHandle.get<String>(Constants.PARAM_USER_NAME)?.let { userName ->
            getUser(userName)
            getUserEvents(userName)
        }
    }

    private fun getUser(userName: String) {
        getUserUseCase(userName).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UserDetailState(userDetail = result.data)
                }

                is Resource.Error -> {
                    _state.value = UserDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    _state.value = UserDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getUserEvents(userName: String) {
        getUserEventsUseCase(userName).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _activityState.value =
                        UserActivityState(userActivities = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _activityState.value = UserActivityState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    _activityState.value = UserActivityState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}