package com.example.spacevent.model.emptities

import com.example.spacevent.model.database.Review

data class Places(
    val id: String,
    val type: String,
    val countPeople: String,
    val city: String,
    val price: Int,
    val address: String,
    val contacts: String,
    val images: Array<String>,
    val logo: String,
    val name: String,
    val rating: Double,
    val reviews: Array<Review>,
    val videous: Array<String>
)
