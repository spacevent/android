package com.example.spacevent.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacevent.model.database.PlacesDataSource
import com.example.spacevent.model.emptities.Review
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PlacesViewModel : ViewModel() {
    private val _reviews by lazy { MutableLiveData<List<Review>>() }
    val reviews: LiveData<List<Review>>
        get() = _reviews

    private val placesDataSources = PlacesDataSource
    private lateinit var listenerPlaces: ListenerRegistration

    fun getPlaces() = placesDataSources.places

    fun enableListenerPlaces() {
        listenerPlaces = placesDataSources.getListenerPlaces()
    }

    fun disableListener() {
        listenerPlaces.remove()
    }
}