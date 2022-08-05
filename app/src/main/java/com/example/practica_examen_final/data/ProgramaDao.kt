package com.clinica_medica.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.practica_examen_final.model.Programa

@Dao
interface ProgramaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPrograma(programa: Programa)

    @Update (onConflict = OnConflictStrategy.IGNORE)
    suspend fun updatePrograma(programa: Programa)

    @Query ("SELECT * FROM PROGRAMA")
    fun getAllData(): LiveData<List<Programa>>
}