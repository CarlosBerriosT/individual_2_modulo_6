package com.example.individual_2_modulo_6

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [Consumo::class], version = 1)
abstract class ConsumoDatabase : RoomDatabase() {
    abstract fun consumoDao(): ConsumoDao

    companion object {
        @Volatile
        private var INSTANCE: ConsumoDatabase? = null

        fun getDatabase(context: Context): ConsumoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ConsumoDatabase::class.java,
                    "consumo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
