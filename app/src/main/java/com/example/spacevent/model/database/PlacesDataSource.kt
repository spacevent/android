package com.example.spacevent.model.database

import com.example.spacevent.model.emptities.ServiceModel
import com.example.spacevent.model.emptities.Review
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object PlacesDataSource {
    private val db = FirebaseFirestore.getInstance()

    fun getQueryPlaces(): Query {
        return db.collection("regions")
            .document("Saint-Petersburg")
            .collection("cities")
            .document("Saint-Petersburg")
            .collection("places")
    }

    fun getQueryReviews(placeId: String): Query {
        return db.collection("places").document(placeId).collection("reviews")
    }

    suspend fun createPlace(serviceModel: ServiceModel): Task<DocumentReference> =
        withContext(Dispatchers.IO) {
            return@withContext db.collection("regions ")
                .document("Saint-Petersburg")
                .collection("cities")
                .document("Saint-Petersburg")
                .collection("places").add(serviceModel)
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