package com.example.practica_examen_final.repository

import androidx.lifecycle.LiveData
import com.clinica_medica.data.ProgramaDao
import com.example.practica_examen_final.model.Programa

class ProgramaRepository(private val programaDao: ProgramaDao) {

    val getAllData: LiveData<List<Programa>> = programaDao.getAllData()

    suspend fun addPrograma(programa: Programa) {
        programaDao.addPrograma(programa)
    }

    suspend fun updatePrograma(programa: Programa) {
        programaDao.updatePrograma(programa)
    }
}