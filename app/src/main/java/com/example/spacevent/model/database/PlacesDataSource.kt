package com.example.spacevent.model.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.spacevent.model.emptities.Places
import com.example.spacevent.model.emptities.Review
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.*
import kotlinx.coroutines.Dispatchers

object PlacesDataSource {
    private val db = FirebaseFirestore.getInstance()

    fun getQueryPlaces(): Query {
        return db.collection("places")
    }

    fun getQueryReviews(placeId: String): Query {
        return db.collection("places").document(placeId).collection("reviews")
    }

}