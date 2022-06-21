package com.example.listadeexchanges.ui.theme.Scrrens.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.listadeexchanges.data.remote.dto.ExchangeDto

@Composable
fun ExchangeItem(
    exchange: ExchangeDto,
    onClick: (ExchangeDto) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick(exchange) }
        .padding(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = exchange.name,
            style = MaterialTheme.typography.body1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(100.dp)
        )

        Text(
            text = if (exchange.active) "Activa" else "Inactiva",
            style = MaterialTheme.typography.body2,
            color = if (exchange.active) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.align(CenterVertically)
        )

        Text(
            text = exchange.last_updated,
            style = MaterialTheme.typography.body2,
            overflow = TextOverflow.Ellipsis
        )
    }

}