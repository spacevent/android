package com.example.spacevent.ui.screens.listServices

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.spacevent.ui.components.InputTextDialog
import com.example.spacevent.ui.screens.detailService.*
import com.example.spacevent.ui.theme.PurpleAlpha
import com.example.spacevent.viewmodel.ServiceViewModel
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
fun ListServicesView(navController: NavController) {
    val viewModel: ServiceViewModel = viewModel()
    viewModel.enableListenerPlaces()

    val places by viewModel.places.observeAsState()
    places?.let {
        LazyColumn {
            items(it) {
                navController.currentBackStackEntry?.savedStateHandle?.set("service", it)
            }
        }

    }
}