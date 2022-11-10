package com.example.spacevent.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacevent.model.database.PlacesDataSource
import com.example.spacevent.model.emptities.Review
import com.google.firebase.firestore.ListenerRegistration

class ReviewViewModel : ViewModel() {
    private val placesDataSources = PlacesDataSource
    private lateinit var listener: ListenerRegistration

    private val _reviews by lazy { MutableLiveData<List<Review>>() }
    val reviews: LiveData<List<Review>>
        get() = _reviews

    private val _error by lazy { MutableLiveData<String>() }
    val error: LiveData<String>
        get() = _error

    private fun showError() {
        _error.value = "Ошибка сервера при обновлении, попробуйте еще раз"
    }

    fun enableListenerReviews(placeId: String) {
        val query = PlacesDataSource.getQueryReviews(placeId)

        listener = query.addSnapshotListener { value, error ->
            if (value != null) {
                _reviews.value = value.toObjects(Review::class.java)
            } else {
                showError()
            }
        }
    }

    fun disableListener() {
        listener.remove()
    }
}