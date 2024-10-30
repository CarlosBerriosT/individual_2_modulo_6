package com.example.individual_2_modulo_6

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ConsumoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ConsumoRepository
    private val _consumptions = MutableLiveData<List<Consumo>>()
    val consumptions: LiveData<List<Consumo>> get() = _consumptions

    init {
        val consumoDao = ConsumoDatabase.getDatabase(application).consumoDao()
        repository = ConsumoRepository(consumoDao)
    }

    fun addConsumo(consumo: Consumo) {
        viewModelScope.launch {
            repository.addConsumo(consumo)
            fetchConsumptions()  // Actualiza la lista
        }
    }

    fun fetchConsumptions() {
        viewModelScope.launch {
            _consumptions.value = repository.getConsumptions()
        }
    }
}
