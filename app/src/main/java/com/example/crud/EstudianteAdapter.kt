package com.example.crud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.databinding.EstudianteBinding

class EstudianteAdapter: RecyclerView.Adapter<EstudianteAdapter.EstudianteViewHolder>() {

    private var estudiantes: ArrayList<EstudianteModel> = ArrayList()

    inner class EstudianteViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val binding = EstudianteBinding.bind(itemview)

        fun bindViewEstudiante(estudiante: EstudianteModel) {
            with(binding) {
                tvNombreEstudiante.text = estudiante.nombre
                tvCorreoEstudiante.text = estudiante.correoElectronico
                tvCursoEstudiante.text = estudiante.curso
            }
        }
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstudianteViewHolder {
//        TODO("Not yet implemented")
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EstudianteViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.estudiante, parent, false)
    )

    override fun getItemCount(): Int = estudiantes.size

    override fun onBindViewHolder(holder: EstudianteViewHolder, position: Int) {
        val estudiante = estudiantes[position]
        holder.bindViewEstudiante(estudiante)
    }


    fun addEstudiante(estudiantes: ArrayList<EstudianteModel>)
    {
        this.estudiantes = estudiantes
        notifyDataSetChanged() //recarga el adaptador
    }
}