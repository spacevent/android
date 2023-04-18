package com.example.spacevent.ui.screens.detailService

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.spacevent.ui.components.CardInformation
import com.example.spacevent.ui.components.CardInformationText
import com.example.spacevent.viewmodel.ServiceViewModel

@Composable
fun RatesScreen(serviceId: String, viewModel: ServiceViewModel) {
    LaunchedEffect(key1 = Unit, block = {
        viewModel.getRates(serviceId)
    })
    val rates by viewModel.rates.observeAsState(emptyList())
    if (rates.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .background(MaterialTheme.colors.background)
                .padding(top = 64.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(rates) {
                CardInformation(title = it.name) {
                    Text(it.description)
                    Text("${it.price} рублей", style = MaterialTheme.typography.h5)
                }
            }
        }
    }
}