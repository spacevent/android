package com.example.spacevent.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacevent.model.database.PlacesDataSource
import com.example.spacevent.model.emptities.Rate
import com.example.spacevent.model.emptities.ServiceModel
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.launch

class ServiceViewModel : ViewModel() {
    private val _places by lazy { MutableLiveData<List<ServiceModel>>() }
    val places: LiveData<List<ServiceModel>>
        get() = _places

    private val _error by lazy { MutableLiveData<String>() }
    val error: LiveData<String>
        get() = _error

    private val _rates by lazy { MutableLiveData<List<Rate>>(emptyList()) }
    val rates: LiveData<List<Rate>>
        get() = _rates

    private fun showError(message: String) {
        _error.value = message
    }

    private val placesDataSources = PlacesDataSource
    private lateinit var listener: ListenerRegistration

    fun enableListenerPlaces() = viewModelScope.launch {
        val query = PlacesDataSource.getQueryPlaces()

        listener = query.addSnapshotListener { value, error ->

            if (value != null) {
                _places.value = value.toObjects(ServiceModel::class.java)
            } else {
                showError("Ошибка сервера при обновлении списка площадок")
            }
        }
    }

    fun createPlace(serviceModel: ServiceModel) = viewModelScope.launch {
        placesDataSources.createPlace(serviceModel)
            .addOnSuccessListener {}
            .addOnFailureListener {
                showError("Ошибка создания площадки")
            }
    }

    fun getRates(serviceId: String) = viewModelScope.launch {
        placesDataSources.getRates(serviceId)
            .addOnSuccessListener { _rates.value = it.toObjects(Rate::class.java) }
            .addOnFailureListener {
                showError("Ошибка создания площадки")
            }
    }

    fun disableListener() {
        listener.remove()
    }
}