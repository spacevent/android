package com.example.spacevent.model.database

data class Review(
    val date: String,
    val description: String,
    val evaluation: Double,
    val user: String
)
