package com.example.individual_2_modulo_6



import androidx.lifecycle.LiveData

class ConsumoRepositorio(private val consumoDao: ConsumoDao) {
    val todosLosConsumos: LiveData<List<Consumo>> = consumoDao.obtenerTodosLosConsumos()

    suspend fun insertar(consumo: Consumo) {
        consumoDao.insertar(consumo)
    }

    suspend fun eliminar(consumo: Consumo) {
        consumoDao.eliminar(consumo)
    }

    suspend fun eliminarTodo() {
        consumoDao.eliminarTodo()
    }
}
