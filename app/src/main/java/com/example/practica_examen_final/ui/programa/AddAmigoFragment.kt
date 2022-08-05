package com.example.practica_examen_final.ui.programa

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practica_examen_final.R
import com.example.practica_examen_final.databinding.FragmentAddAmigoBinding
import com.example.practica_examen_final.databinding.FragmentAddProgramaBinding
import com.example.practica_examen_final.model.Programa
import com.example.practica_examen_final.viewmodel.ProgramaViewModel

class AddAmigoFragment : Fragment() {

    private lateinit var programaViewModel: ProgramaViewModel
    private var _binding: FragmentAddAmigoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        programaViewModel = ViewModelProvider(this)[ProgramaViewModel::class.java]
        _binding = FragmentAddAmigoBinding.inflate(inflater, container, false)

        binding.btLlamarAmigo.setOnClickListener { (llamarAmigo())}

        return binding.root
    }

    private fun llamarAmigo() {
        val recurso = binding.etTelefono.text.toString()
        if(recurso.isNotEmpty()) {

            val rutina = Intent(Intent.ACTION_CALL)
            rutina.data = Uri.parse("tel:$recurso")
            if(requireActivity().checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){

                requireActivity().requestPermissions(arrayOf(Manifest.permission.CALL_PHONE),
                    105)
            }else{
                requireActivity().startActivity(rutina)
            }
        } else {
            Toast.makeText(requireContext(),getString(R.string.no_data),Toast.LENGTH_SHORT)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}