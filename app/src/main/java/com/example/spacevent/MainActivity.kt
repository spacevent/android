package com.example.spacevent

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.spacevent.ui.components.BackgroundCardView
import com.example.spacevent.ui.components.CardInformationText
import com.example.spacevent.ui.screens.detailService.CommonInformationDetailService
import com.example.spacevent.ui.theme.Alpha
import com.example.spacevent.ui.theme.Blue
import com.example.spacevent.ui.theme.SpaceventTheme
import com.example.spacevent.viewmodel.ServiceViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: ServiceViewModel = viewModel()
            SpaceventTheme {
                viewModel.enableListenerPlaces()
                val places by viewModel.places.observeAsState()
                /*CommonInformationDetailService()*/
                if (!places.isNullOrEmpty()) {
                    Column(Modifier.fillMaxSize().background(MaterialTheme.colors.background).padding(top = 32.dp)) {
                        CardInformationText(title = "Правила".uppercase(), places!![1].rules)
                    }
                }
            }
        }
    }
}
