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
import androidx.navigation.compose.rememberNavController
import com.example.spacevent.ui.components.InputTextDialog
import com.example.spacevent.ui.navigation.AppNavHost
import com.example.spacevent.ui.navigation.Screens
import com.example.spacevent.ui.screens.detailService.CardCharacteristicsView
import com.example.spacevent.ui.screens.detailService.CommonInformationDetailService
import com.example.spacevent.ui.screens.detailService.PhotosScreen
import com.example.spacevent.ui.screens.detailService.RatesScreen
import com.example.spacevent.ui.theme.PurpleAlpha
import com.example.spacevent.ui.theme.SpaceventTheme
import com.example.spacevent.viewmodel.AuthorizationViewModel
import com.example.spacevent.viewmodel.ServiceViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: AuthorizationViewModel = viewModel()
            val isAuthorization by viewModel.isAuthorization.collectAsState()
            LaunchedEffect(key1 = Unit, block = { viewModel.checkAuthorization() })
            val navController = rememberNavController()
            SpaceventTheme {
                isAuthorization?.let {
                    val startDestination = if (it) Screens.Main.route else Screens.SignIn.route

                    AppNavHost(navController = navController, startDestination = startDestination) {
                    }
                }
            }
        }
    }
}


