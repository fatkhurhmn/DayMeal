package com.muffar.daymeal.presentation.meals

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
class MealsViewModel @Inject constructor(
    private val mealUseCases: MealUseCases,
) : ViewModel() {

    private val _state = mutableStateOf(MealsState())
    val state: State<MealsState> = _state

    fun getMealsByCategory(category: String) {
        viewModelScope.launch {
            mealUseCases.getMealsByCategory(category).onEach {
                when (it) {
                    is Resource.Loading -> _state.value = _state.value.copy(
                        meals = null,
                        isLoading = true,
                        isError = false
                    )

                    is Resource.Success -> _state.value = _state.value.copy(
                        meals = it.value,
                        isLoading = false,
                        isError = false,
                    )

                    is Resource.Error -> _state.value = _state.value.copy(
                        meals = null,
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