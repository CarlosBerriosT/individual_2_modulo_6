package com.example.individual_2_modulo_6


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Consumo::class], version = 1, exportSchema = false)
abstract class ConsumoRoomDatabase : RoomDatabase() {
    abstract fun consumoDao(): ConsumoDao

    companion object {
        @Volatile
        private var INSTANCE: ConsumoRoomDatabase? = null

        fun obtenerBaseDeDatos(context: Context): ConsumoRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ConsumoRoomDatabase::class.java,
                    "consumo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}