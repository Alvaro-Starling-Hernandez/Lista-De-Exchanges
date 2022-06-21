package com.example.listadeexchanges.ui.theme.Scrrens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadeexchanges.data.remote.ExchangesRepository
import com.example.listadeexchanges.ui.theme.Scrrens.ExchangeListState
import com.example.listadeexchanges.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
    private val exchangesRepository: ExchangesRepository
) : ViewModel() {

    private val _state = mutableStateOf(ExchangeListState())
    val state: State<ExchangeListState> = _state

    init {
        exchangesRepository.getExchanges().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ExchangeListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ExchangeListState(exchanges = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ExchangeListState(error = result.message ?: "Error desconocido")
                }
            }
        }.launchIn(viewModelScope)
    }

}