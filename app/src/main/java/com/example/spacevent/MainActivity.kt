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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.spacevent.ui.screens.detailService.CardCharacteristicsView
import com.example.spacevent.ui.screens.detailService.CommonInformationDetailService
import com.example.spacevent.ui.screens.detailService.RatesScreen
import com.example.spacevent.ui.theme.PurpleAlpha
import com.example.spacevent.ui.theme.SpaceventTheme
import com.example.spacevent.viewmodel.ServiceViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

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
                    if (it.isNotEmpty()) {
                        Box {
                            val state = rememberPagerState()
                            var currentPage by remember { mutableStateOf(0) }
                            /*LaunchedEffect(key1 = currentPage, block = {
                                delay(6000)
                                state.animateScrollToPage(currentPage, 1f)
                                currentPage = (currentPage + 1) % 2

                            })*/
                            HorizontalPager(count = 3, state = state) { indexPage ->
                                when (indexPage) {
                                    0 -> CommonInformationDetailService(
                                        "https://i.pinimg.com/564x/e0/f6/46/e0f6469552c6aead5a8a7ca8add29354.jpg",
                                        it[2].name,
                                        it[2].profession,
                                        it[2].numericalParameters,
                                        it[2].sellingText

                                    )

                                    1 -> CardCharacteristicsView(
                                        it[2].characteristics,
                                        it[2].rules,
                                        it[2].workingHours
                                    )

                                    2 -> RatesScreen(it[2].id, viewModel)
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
