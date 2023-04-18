package com.example.spacevent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.spacevent.ui.components.InputTextDialog
import com.example.spacevent.ui.screens.detailService.CardCharacteristicsView
import com.example.spacevent.ui.screens.detailService.CommonInformationDetailService
import com.example.spacevent.ui.screens.detailService.PhotosScreen
import com.example.spacevent.ui.screens.detailService.RatesScreen
import com.example.spacevent.ui.theme.PurpleAlpha
import com.example.spacevent.ui.theme.SpaceventTheme
import com.example.spacevent.viewmodel.ServiceViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: ServiceViewModel = viewModel()
            SpaceventTheme {
                viewModel.enableListenerPlaces()

                val places by viewModel.places.observeAsState()
                places?.let {

                    LaunchedEffect(key1 = Unit, block = {
                        viewModel.getRates(it[2].id)
                    })
                    val rates by viewModel.rates.observeAsState(emptyList())

                    if (it.isNotEmpty()) {
                        Box {
                            val state = rememberPagerState()
                            var currentPage by remember { mutableStateOf(0) }
                            var isVisibleInputTextDialog by remember { mutableStateOf(false) }

                            if (isVisibleInputTextDialog && !rates.isNullOrEmpty()) {
                                InputTextDialog(
                                    service = it[2].name,
                                    rates = rates,
                                    onDismissRequest = { isVisibleInputTextDialog = false },
                                    createRequest = {}
                                )
                            }

                            HorizontalPager(count = 4, state = state) { indexPage ->
                                when (indexPage) {
                                    0 -> CommonInformationDetailService(
                                        "https://i.pinimg.com/564x/e0/f6/46/e0f6469552c6aead5a8a7ca8add29354.jpg",
                                        it[2].name,
                                        it[2].profession,
                                        it[2].numericalParameters,
                                        it[2].sellingText
                                    ) { isVisibleInputTextDialog = true }

                                    1 -> CardCharacteristicsView(
                                        it[2].characteristics,
                                        it[2].rules,
                                        it[2].workingHours
                                    )

                                    2 -> RatesScreen(
                                        it[2].id,
                                        viewModel
                                    ) { isVisibleInputTextDialog = true }
                                    3 -> PhotosScreen(it[2].photos)
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

                }
            }
        }
    }
}
