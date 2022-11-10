package com.example.spacevent.model.database

import com.example.spacevent.model.emptities.Place
import com.example.spacevent.model.emptities.Review
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.*

object PlacesDataSource {
    private val db = FirebaseFirestore.getInstance()

    fun getQueryPlaces(): Query {
        return db.collection("places")
    }

    fun getQueryReviews(placeId: String): Query {
        return db.collection("places").document(placeId).collection("reviews")
    }

    suspend fun createPlace(place: Place): Task<Void> {
        return db.collection("places").document(place.id).set(place)
    }

    suspend fun updatePlace(placeId: String, changes: Map<String, Any>): Task<Void> {
        return db.collection("places").document(placeId).update(changes)
    }

    suspend fun createReview(placeId: String, review: Review): Task<Void> {
        return db.collection("places")
            .document(placeId).collection("reviews")
            .document(review.user).set(review)
    }

    suspend fun updateReview(
        placeId: String,
        reviewId: String,
        changes: Map<String, Any>
    ): Task<Void> {
        return db.collection("places")
            .document(placeId).collection("reviews")
            .document(reviewId).update(changes)
    }

}