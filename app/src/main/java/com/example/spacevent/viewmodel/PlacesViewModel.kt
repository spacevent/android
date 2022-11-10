package com.example.spacevent.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacevent.model.database.PlacesDataSource
import com.example.spacevent.model.emptities.Places
import com.example.spacevent.model.emptities.Review
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PlacesViewModel : ViewModel() {
    private val _reviews by lazy { MutableLiveData<List<Review>>() }
    val reviews: LiveData<List<Review>>
        get() = _reviews

    private val _places by lazy { MutableLiveData<List<Places>>() }
    val places: LiveData<List<Places>>
        get() = _places

    private val _error by lazy {  MutableLiveData<String>() }
    val error: LiveData<String>
        get() = _error

    private fun showError() {
        _error.value = "Ошибка сервера при обновлении, попробуйте еще раз"
    }

    private val placesDataSources = PlacesDataSource
    private lateinit var listener: ListenerRegistration

    fun enableListenerPlaces() {
        val query = PlacesDataSource.getQueryPlaces()

        listener = query.addSnapshotListener { value, error ->
            if (value != null) {
                _places.value = value.toObjects(Places::class.java)
            } else {
                showError()
            }
        }
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