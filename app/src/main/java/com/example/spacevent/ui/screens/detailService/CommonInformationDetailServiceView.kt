package com.example.spacevent.ui.screens.detailService

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.spacevent.ui.components.BackgroundCardView
import com.example.spacevent.ui.theme.Alpha
import com.example.spacevent.ui.theme.Blue
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CommonInformationDetailService() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        GlideImage(
            imageModel = "https://espanarusa.com/files/autoupload/48/93/70/12c1uhdh376605.jpg",
            modifier = Modifier.height(390.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(390.dp)
                .background(Brush.verticalGradient(listOf(Alpha, Alpha, Blue)))
        )

        BackgroundCardView(
            Modifier
                .fillMaxSize()
                .padding(top = 350.dp)
        ) {
            CardContent()
        }

        NumberCharacteristicsView(Modifier.padding(top = 320.dp))
    }
}

@Composable
private fun CardContent() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 60.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Диджей арбуз",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSecondary
        )

        Text(
            text = "Диджей на выезд, г. Санкт-Петербург"
        )

        Text(
            text = "О себе",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = "Вот знаете, а я могла бы не генерировать эту часть текста из головы, а использовать чат GPT, но мне слишком лень открывать его сейчас, поэтому потерпите ещё немного"
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(0.7f).padding(top = 48.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(text = "Заказать сейчас", modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}