package com.example.spacevent.ui.screens.detailService

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spacevent.viewmodel.ServiceViewModel

@Composable
fun RatesScreen(serviceId: String, viewModel: ServiceViewModel, showDialog: () -> Unit) {
    LaunchedEffect(key1 = Unit, block = {
        viewModel.getRates(serviceId)
    })
    val rates by viewModel.rates.observeAsState(emptyList())
    if (rates.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.secondary)
                .padding(top = 64.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(rates) {
                Card(
                    Modifier.padding(horizontal = 16.dp),
                    backgroundColor = MaterialTheme.colors.surface,
                    elevation = 16.dp
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = it.name.uppercase(), style = MaterialTheme.typography.h5)

                        Text(
                            it.description,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            textAlign = TextAlign.Center
                        )

                        Text(
                            "Стоимость: ${it.price} рублей",
                            fontWeight = FontWeight.Bold,
                        )

                        Button(onClick = { showDialog() }) {
                            Text(text = "Написать продавцу", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}