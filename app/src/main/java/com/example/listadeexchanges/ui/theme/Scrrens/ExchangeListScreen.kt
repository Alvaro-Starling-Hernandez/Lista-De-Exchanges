package com.example.listadeexchanges.ui.theme.Scrrens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.listadeexchanges.ui.theme.Scrrens.Components.ExchangeItem

@Composable
fun ExchangeListScreen(
    viewModel: ExchangeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value


    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text("Lista de Exchanges")
                }
            )
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .absolutePadding(16.dp, 16.dp, 16.dp, 16.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Name",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "State",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 25.dp)
                )
                Text(
                    text = "Last Updated",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
            }

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(state.exchanges) { exchange ->
                    ExchangeItem(exchange = exchange, onClick = {})
                }
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(alignment = CenterHorizontally))
            }
        }
    }
}