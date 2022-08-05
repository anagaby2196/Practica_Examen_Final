package com.example.practica_examen_final.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_examen_final.databinding.ProgramaFilaBinding
import com.example.practica_examen_final.model.Programa
import com.example.practica_examen_final.ui.programa.ProgramaFragmentDirections

class ProgramaAdapter : RecyclerView.Adapter<ProgramaAdapter.ProgramaViewHolder>() {

    private var listaProgramas = emptyList<Programa>()

    inner class ProgramaViewHolder(private val itemBinding: ProgramaFilaBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(programa : Programa) {
            itemBinding.tvNombrePrograma.text = programa.nombrePrograma
            itemBinding.tvDescripcionPrograma.text = programa.descripcionPrograma
            itemBinding.tvCanal.text = programa.canal.toString()
            itemBinding.tvProductor.text = programa.productor
            itemBinding.tvHora.text = programa.hora.toString()

            itemBinding.vistaFila.setOnClickListener{
                val accion = ProgramaFragmentDirections.actionNavProgramaToUpdateProgramaFragment(programa)
                itemView.findNavController().navigate(accion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramaViewHolder {
        val itemBinding = ProgramaFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProgramaViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ProgramaViewHolder, position: Int) {
        val programa = listaProgramas[position]
        holder.dibuja(programa)
    }

    override fun getItemCount(): Int {
        return listaProgramas.size
    }

    fun setData(programas : List<Programa>) {
        this.listaProgramas = programas
        notifyDataSetChanged()
    }
}