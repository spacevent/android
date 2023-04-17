package com.example.spacevent.ui.screens.detailService

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.spacevent.ui.components.CardInformationText

@Composable
fun CardCharacteristicsView(
    characteristics: Map<String, String>,
    rules: List<String>,
    workingHours: List<String>
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(scrollState)
            .background(MaterialTheme.colors.background)
            .padding(top = 64.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
        CardInformationText(title = "Характеристики".uppercase(), characteristics)
        CardInformationText(title = "Время работы".uppercase(), workingHours)
        CardInformationText(title = "Правила".uppercase(), rules)
    }
}
