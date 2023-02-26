package com.example.spacevent.model.emptities

import java.util.UUID

data class Place(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "",
    val type: String = "loft",
    val countPeople: Int = 0,
    val city: String = "",
    val pricies: List<Int> = emptyList(),
    val rules: List<String> = emptyList(),
    val address: String = "",
    val contacts: String = "",
    val images: List<String> = emptyList(),
    val logo: String = "",
    val rating: List<Double> = emptyList(),
    val videous: List<String> = emptyList()
)
