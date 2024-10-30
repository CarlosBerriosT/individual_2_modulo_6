package com.example.individual_2_modulo_6

class ConsumoRepository(private val consumoDao: ConsumoDao) {
    suspend fun addConsumo(consumo: Consumo) {
        consumoDao.insert(consumo)
    }

    suspend fun getConsumptions(): List<Consumo> {
        return consumoDao.getAllConsumptions()
    }
}
