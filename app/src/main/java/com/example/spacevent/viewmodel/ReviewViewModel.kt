package com.example.spacevent.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacevent.model.database.PlacesDataSource
import com.example.spacevent.model.emptities.Review
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.launch

class ReviewViewModel : ViewModel() {
    private val placesDataSources = PlacesDataSource
    private lateinit var listener: ListenerRegistration

    private val _reviews by lazy { MutableLiveData<List<Review>>() }
    val reviews: LiveData<List<Review>>
        get() = _reviews

    private val _error by lazy { MutableLiveData<String>() }
    val error: LiveData<String>
        get() = _error

    private fun showError(message: String) {
        _error.value = message
    }

    fun enableListenerReviews(placeId: String) {
        val query = PlacesDataSource.getQueryReviews(placeId)

        listener = query.addSnapshotListener { value, error ->
            if (value != null) {
                _reviews.value = value.toObjects(Review::class.java)
            } else {
                showError("Ошибка сервера при обновлении списка отзывов")
            }
        }
    }

    fun createReview(placeId: String, review: Review) = viewModelScope.launch {
        placesDataSources.createReview(placeId, review)
            .addOnSuccessListener {}
            .addOnFailureListener {
                showError("Ошибка создания отзыва")
            }
    }

    fun disableListener() {
        listener.remove()
    }
}