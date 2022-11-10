package com.example.spacevent.model.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.spacevent.model.emptities.Places
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.*
import kotlinx.coroutines.Dispatchers

object PlacesDataSource {
    private val db = FirebaseFirestore.getInstance()
    private val dispatcher = Dispatchers.IO

    private val _places = MutableLiveData(emptyList<Places>())
    val places: LiveData<List<Places>>
        get() = _places

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private lateinit var snapshotListenerPlaces: ListenerRegistration

    private fun getQueryPlaces(): Query {
        return db.collection("places")
    }

    fun enableSnapshotListenerPlaces() {
        val query = getQueryPlaces()

        snapshotListenerPlaces = query.addSnapshotListener { value, error ->
            if (value != null) {
                _places.value = value.toObjects(Places::class.java)
            } else {
                _error.value = "Ошибка сервера при обновлении, попробуйте еще раз"
            }
        }
    }

    fun disableSnapshotListenerPlaces() {
        snapshotListenerPlaces.remove()
    }
}