package com.example.practica_examen_final.ui.programa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practica_examen_final.R
import com.example.practica_examen_final.databinding.FragmentAddProgramaBinding
import com.example.practica_examen_final.model.Programa
import com.example.practica_examen_final.viewmodel.ProgramaViewModel

class AddProgramaFragment : Fragment() {

    private lateinit var programaViewModel: ProgramaViewModel
    private var _binding: FragmentAddProgramaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        programaViewModel = ViewModelProvider(this)[ProgramaViewModel::class.java]
        _binding = FragmentAddProgramaBinding.inflate(inflater, container, false)

        binding.btAddPrograma.setOnClickListener { addPrograma() }

        return binding.root
    }

    private fun addPrograma() {
        val nombrePrograma=binding.etNombrePrograma.text.toString()
        val descripcionPrograma=binding.etDescripcionPrograma.text.toString()
        val hora=binding.etHora.text.toString()
        val canal=binding.etCanal.text.toString()
        val productor=binding.etProductor.text.toString()

        if(nombrePrograma.isNotEmpty()) {
            val programa = Programa(0,nombrePrograma,descripcionPrograma,hora.toDouble(),canal.toInt(),productor)
            programaViewModel.addPrograma(programa)
            Toast.makeText(requireContext(),getString(R.string.programa_added), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addProgramaFragment_to_nav_programa)
        } else {
            Toast.makeText(requireContext(),getString(R.string.no_data), Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}