package com.example.practica_examen_final.ui.programa

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.practica_examen_final.R
import com.example.practica_examen_final.databinding.FragmentUpdateProgramaBinding
import com.example.practica_examen_final.model.Programa
import com.example.practica_examen_final.viewmodel.ProgramaViewModel

class UpdateProgramaFragment : Fragment() {

    private val args by navArgs<UpdateProgramaFragmentArgs>()

    private lateinit var programaViewModel: ProgramaViewModel
    private var _binding: FragmentUpdateProgramaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        programaViewModel = ViewModelProvider(this)[ProgramaViewModel::class.java]
        _binding = FragmentUpdateProgramaBinding.inflate(inflater, container, false)

        binding.etNombrePrograma.setText(args.programa.nombrePrograma)
        binding.etDescripcionPrograma.setText(args.programa.descripcionPrograma)
        binding.etHora.setText(args.programa.hora.toString())
        binding.etCanal.setText(args.programa.canal.toString())
        binding.etProductor.setText(args.programa.productor)

        binding.btActualizarPrograma.setOnClickListener { updatePrograma() }


        setHasOptionsMenu(true)

        return binding.root
    }

    private fun updatePrograma() {
        val nombrePrograma=binding.etNombrePrograma.text.toString()
        val descripcionPrograma=binding.etDescripcionPrograma.text.toString()
        val hora=binding.etHora.text.toString()
        val canal=binding.etCanal.text.toString()
        val productor=binding.etProductor.text.toString()

        if(nombrePrograma.isNotEmpty()) {
            val programa = Programa(args.programa.id,nombrePrograma,descripcionPrograma,hora.toDouble(),canal.toInt(),productor)
            programaViewModel.updatePrograma(programa)
            Toast.makeText(requireContext(),getString(R.string.programa_updated), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateProgramaFragment_to_nav_programa)
        } else {
            Toast.makeText(requireContext(),getString(R.string.no_data), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}