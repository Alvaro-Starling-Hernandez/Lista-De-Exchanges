package com.example.listadeexchanges.ui.theme.Scrrens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.listadeexchanges.ui.theme.Scrrens.Components.ExchangeItem
import com.example.listadeexchanges.ui.theme.Scrrens.Components.ExchangeViewModel

@Composable
fun ExchangeListScreen(
    viewModel: ExchangeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.exchanges) { exchange ->
                ExchangeItem(exchange = exchange, onClick = {})
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}