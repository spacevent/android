package com.example.spacevent.model.emptities

import com.example.spacevent.model.database.Review
import com.google.firebase.firestore.DocumentReference
import java.util.UUID

data class Places(
    val id: String = UUID.randomUUID().toString(),
    val type: String = "loft",
    val countPeople: Int = 0,
    val city: String = "",
    val price: Int = 0,
    val address: String = "",
    val contacts: String = "",
    val images: List<String> = emptyList(),
    val logo: String = "",
    val name: String = "",
    val rating: Double = 0.0,
    val reviews: List<DocumentReference> = emptyList(),
    val videous: List<String> = emptyList()
)
