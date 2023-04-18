package com.example.spacevent.model.emptities

import java.util.*

data class Request(
    val service: String,
    val contact: String,
    val rate: String,
    val date: Date,
    val startTime: String,
    val endTime: String
)