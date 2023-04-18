package com.example.spacevent.ui.screens.detailService

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PhotosScreen(photos: List<String>) {
    var selectedPhoto by remember { mutableStateOf("") }

    BackHandler {
        selectedPhoto = ""
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(top = 64.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(photos) {

            Card(
                Modifier
                    .height(200.dp).padding(horizontal = 32.dp)
                    .clickable { selectedPhoto = it },
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 8.dp
            ) {
                GlideImage(imageModel = it, Modifier.fillMaxSize().padding(3.dp))
            }
        }
    }

    AnimatedVisibility(visible = selectedPhoto != "") {
        GlideImage(
            imageModel = selectedPhoto,
            Modifier
                .fillMaxSize()
                .clickable { selectedPhoto = "" })
    }
}