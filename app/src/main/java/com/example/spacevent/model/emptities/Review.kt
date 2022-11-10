package com.example.spacevent.model.emptities

@kotlinx.serialization.Serializable
data class Review(
    val date: String = "",
    val description: String = "",
    val evaluation: Double = 0.0,
    val user: String = ""
)
