package com.clinica_medica.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practica_examen_final.model.Programa

@Database(entities = [Programa::class], version = 1, exportSchema = false)

abstract class ProgramaDatabase : RoomDatabase() {
    abstract fun programaDao() : ProgramaDao

    companion object {
        @Volatile
        private var INSTANCE: ProgramaDatabase? = null

        fun getDatabase(context: android.content.Context) : ProgramaDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProgramaDatabase::class.java,
                    "practica_examen_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}