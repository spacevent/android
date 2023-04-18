package com.example.spacevent.ui.components

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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun CardInformation(title: String, content: @Composable () -> Unit) {
    Box(contentAlignment = Alignment.BottomCenter) {
        Column(
            modifier = Modifier
                .height(180.dp)
                .padding(horizontal = 32.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(MaterialTheme.colors.primaryVariant)
                .padding(bottom = 8.dp),
        ) {
            Text(
                text = title,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.surface)
                    .padding(vertical = 8.dp)
            )
            content()
        }
    }
}

@Composable
fun CardInformationText(
    title: String,
    items: List<String>,
) {
    CardInformation(title = title) {

        val text = buildString {
            items.forEach { append("● $it \n") }
        }


        Text(
            text = text,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            color = MaterialTheme.colors.onSurface
        )
    }

}

@Composable
fun CardInformationText(
    title: String,
    items: Map<String, String>,
) {
    Box(contentAlignment = Alignment.BottomCenter) {
        Column(
            modifier = Modifier
                .height(180.dp)
                .padding(horizontal = 32.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(MaterialTheme.colors.primaryVariant)
                .padding(bottom = 8.dp),
        ) {
            Text(
                text = title,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.surface)
                    .padding(vertical = 8.dp)
            )

            val text = buildAnnotatedString {
                items.forEach {
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("● ${it.key}:")
                    }
                    append("${it.value} \n")
                }
            }


            Text(
                text = text,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}