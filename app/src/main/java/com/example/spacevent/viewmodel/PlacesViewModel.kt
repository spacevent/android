package com.example.spacevent.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacevent.model.database.PlacesDataSource
import com.example.spacevent.model.emptities.Place
import com.example.spacevent.model.emptities.Review
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.launch

class PlacesViewModel : ViewModel() {
    private val _places by lazy { MutableLiveData<List<Place>>() }
    val places: LiveData<List<Place>>
        get() = _places

    private val _error by lazy { MutableLiveData<String>() }
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
                _places.value = value.toObjects(Place::class.java)
            } else {
                showError()
            }
        }
    }

    fun disableListener() {
        listener.remove()
    }
}