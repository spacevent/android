package com.example.spacevent.ui.screens.detailService

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberCharacteristicsView(
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(32.dp),
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier.fillMaxWidth(0.9f)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 1..3) {
                Column {
                    Text(
                        "8",
                        style = MaterialTheme.typography.h5,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(90.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        "Количество комнат",
                        color = Color.White,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(90.dp)
                    )
                }

                if (i != 3) Spacer(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxHeight(0.5f)
                        .width(2.dp)
                        .background(Color.White)
                )
            }
        }
    }
}