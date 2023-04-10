package com.example.spacevent.model.emptities

import com.google.firebase.firestore.Query

data class ServiceModel(
        val id: String = "",
        val name: String = "",
        val profession: String = "loft",
        val category: String = "",
        val amountOfReviews: Int = 0,
        val reviews: Int = 0,
        val numericalParameters: Map<String, Int> = emptyMap<String, Int>(),
        val workingHours: List<String> = emptyList(),
        val sellingText: String = "",
        val characteristics: Map<String, String> = emptyMap<String, String>(),
        val rules: List<String> = emptyList(),
        val otherServices: List<Query> = emptyList(),
        val contacts: Map<String, String> = emptyMap<String, String>(),
        val address: String = "",
        val photos: List<String> = emptyList(),
        val videos: List<String> = emptyList()
)
data class Item(val name: String = "")
