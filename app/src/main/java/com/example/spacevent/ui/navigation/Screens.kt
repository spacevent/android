package com.example.spacevent.ui.navigation

sealed class Screens(val route: String) {
    object SignIn : Screens("signIn")
    object Registration : Screens("registration")
    object Main : Screens("main")
}