package com.example.individual_2_modulo_6

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface ConsumoDao {
    @Insert
    suspend fun insertar(consumo: Consumo)

    @Query("SELECT * FROM consumos")
    fun obtenerTodosLosConsumos(): LiveData<List<Consumo>>

    @Delete
    suspend fun eliminar(consumo: Consumo)

    @Query("DELETE FROM consumos")
    suspend fun eliminarTodo()
}
