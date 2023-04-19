package com.example.spacevent.model.emptities

import com.google.firebase.firestore.DocumentReference
import java.util.UUID

data class Worker(
    val id: String = UUID.randomUUID().toString(),
    val email: String = "",
    val services: List<DocumentReference> = emptyList()
)
