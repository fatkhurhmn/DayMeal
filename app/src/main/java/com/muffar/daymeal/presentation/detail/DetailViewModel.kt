package com.muffar.daymeal.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muffar.daymeal.data.Resource
import com.muffar.daymeal.domain.usecase.MealUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val mealUseCases: MealUseCases,
) : ViewModel() {

    private val _state = mutableStateOf(DetailState())
    val state: State<DetailState> = _state

    fun getMealDetail(id: String) {
        viewModelScope.launch {
            mealUseCases.getMealDetail(id).onEach {
                when (it) {
                    is Resource.Loading -> _state.value = _state.value.copy(
                        meal = null,
                        isLoading = true,
                        isError = false
                    )

                    is Resource.Success -> _state.value = _state.value.copy(
                        meal = it.value,
                        isLoading = false,
                        isError = false,
                    )

                    is Resource.Error -> _state.value = _state.value.copy(
                        meal = null,
                        isLoading = false,
                        isError = true,
                        errorMessage = it.message
                    )

                    else -> {}
                }
            }.launchIn(viewModelScope)
        }
    }
}