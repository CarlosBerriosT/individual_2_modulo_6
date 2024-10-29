package com.example.individual_2_modulo_6

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ConsumoViewModel(application: Application) : AndroidViewModel(application) { // Cambia a AndroidViewModel
    private val repositorio: ConsumoRepositorio
    val todosLosConsumos: LiveData<List<Consumo>>

    init {
        val consumoDao = ConsumoRoomDatabase.obtenerBaseDeDatos(application).consumoDao()
        repositorio = ConsumoRepositorio(consumoDao)
        todosLosConsumos = repositorio.todosLosConsumos
    }

    fun insertar(consumo: Consumo) = viewModelScope.launch {
        repositorio.insertar(consumo)
    }

    fun eliminar(consumo: Consumo) = viewModelScope.launch {
        repositorio.eliminar(consumo)
    }

    fun eliminarTodo() = viewModelScope.launch {
        repositorio.eliminarTodo()
    }
}
