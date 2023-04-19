package com.skat.restaurant.ui.features.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.spacevent.model.emptities.Worker
import com.example.spacevent.ui.navigation.Screens
import com.example.spacevent.viewmodel.AuthorizationViewModel
import com.example.spacevent.viewmodel.emailIfValid
import com.example.spacevent.ui.components.TextFieldPassword
import com.skat.restaurant.ui.components.textFields.TextFieldEmail

/**
 * Функция отображения экрана регистрации
 */
@Composable
fun RegisterScreen(navController: NavController) {
    val viewModel = viewModel(AuthorizationViewModel::class.java)

    val isAuthorization by viewModel.isAuthorization.collectAsState()
    if (isAuthorization == true) {
        navController.navigate(Screens.Main.route) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val scrollState = rememberScrollState()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            elevation = 16.dp,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Регистрация", style = MaterialTheme.typography.h5)

                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var repeatPassword by remember { mutableStateOf("") }

                TextFieldEmail(email = email, onValueChange = { email = it })

                TextFieldPassword(
                    password = password,
                    onValueChange = { password = it },
                    isError = password.length < 8 && password.isNotEmpty(),
                    errorText = "Пароль должен содержать 8 символов",
                    labelText = "Пароль"
                )

                TextFieldPassword(
                    password = repeatPassword,
                    onValueChange = { repeatPassword = it },
                    isError = password != repeatPassword && password.isNotEmpty(),
                    errorText = "Пароли не совпадают",
                    labelText = "Подтверждение пароля"
                )

                Button(
                    modifier = Modifier.padding(top = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    onClick = {
                        viewModel.register(
                            Worker(email = email,),
                            password
                        )
                    },
                    enabled = email.emailIfValid() && password.length >= 8 && password == repeatPassword,
                    content = { Text("Зарегистрироваться") }
                )
            }
        }
    }
}