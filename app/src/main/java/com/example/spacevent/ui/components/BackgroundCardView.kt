package com.example.spacevent.ui.components

import android.util.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.spacevent.R

@Composable
fun BackgroundCardView(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        elevation = 16.dp,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.background),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "background"
            )
            Image(
                painter = painterResource(id = R.drawable.background2),
                contentDescription = "background",
                Modifier.fillMaxSize(0.9f).align(Alignment.BottomStart).padding(16.dp)
            )
            content()
        }
    }
}