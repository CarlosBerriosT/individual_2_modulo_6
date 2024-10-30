package com.example.individual_2_modulo_6

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ConsumoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(consumo: Consumo)

    @Query("SELECT * FROM consumos")
    suspend fun getAllConsumptions(): List<Consumo>
}
