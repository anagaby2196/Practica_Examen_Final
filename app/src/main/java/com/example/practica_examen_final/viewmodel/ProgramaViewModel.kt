package com.example.practica_examen_final.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.clinica_medica.data.ProgramaDatabase
import com.example.practica_examen_final.model.Programa
import com.example.practica_examen_final.repository.ProgramaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProgramaViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Programa>>

    private val repository: ProgramaRepository

    init {
        val programaDao = ProgramaDatabase.getDatabase(application).programaDao()
        repository = ProgramaRepository(programaDao)
        getAllData = repository.getAllData
    }

    fun addPrograma (programa: Programa) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPrograma(programa)
        }
    }

    fun updatePrograma (programa: Programa){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePrograma(programa)
        }
    }

}