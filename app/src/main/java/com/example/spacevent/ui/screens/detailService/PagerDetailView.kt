package com.example.spacevent.ui.screens.detailService

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.spacevent.model.emptities.ServiceModel
import com.example.spacevent.ui.components.InputTextDialog
import com.example.spacevent.ui.theme.PurpleAlpha
import com.example.spacevent.viewmodel.ServiceViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerDetailView(service: ServiceModel) {
    Box {
        val viewModel: ServiceViewModel = viewModel()
        LaunchedEffect(key1 = Unit, block = {
            viewModel.getRates(service.id)
        })
        val rates by viewModel.rates.observeAsState(emptyList())


        val state = rememberPagerState()
        var isVisibleInputTextDialog by remember { mutableStateOf(false) }

        if (isVisibleInputTextDialog && !rates.isNullOrEmpty()) {
            InputTextDialog(
                service = service.name,
                rates = rates,
                onDismissRequest = { isVisibleInputTextDialog = false },
                createRequest = {}
            )
        }

        HorizontalPager(count = 4, state = state) { indexPage ->
            when (indexPage) {
                0 -> CommonInformationDetailService(
                    "https://i.pinimg.com/564x/e0/f6/46/e0f6469552c6aead5a8a7ca8add29354.jpg",
                    service.name,
                    service.profession,
                    service.numericalParameters,
                    service.sellingText
                ) { isVisibleInputTextDialog = true }

                1 -> CardCharacteristicsView(
                    service.characteristics,
                    service.rules,
                    service.workingHours
                )

                2 -> RatesScreen(
                    service.id,
                    viewModel
                ) { isVisibleInputTextDialog = true }

                3 -> PhotosScreen(service.photos)
            }
        }

        Row(
            Modifier
                .height(50.dp)
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 36.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(4) { iteration ->
                val color =
                    if (state.currentPage == iteration) MaterialTheme.colors.primary else PurpleAlpha
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(15.dp)
                )
            }
        }
    }
}