package com.example.spacevent.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Горизонтальная линия для отделения контента друг от друга
 * @param[colorSpacer] Цвет линии
 * @param[height] Толщина линии
 * @param[modifier] Модификатор
 */
@Composable
fun HorizontalSpacer(
    colorSpacer: Color = Gray,
    modifier: Modifier = Modifier.fillMaxWidth(),
    height: Dp = 1.dp,
) {
    Spacer(
        modifier = modifier
            .height(height)
            .background(colorSpacer)
    )
}