package com.example.ejemplo_room_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplo_room_view.Adaptadores.TareaListaAdapter
import com.example.ejemplo_room_view.Utils.TareaAppplication
import com.example.ejemplo_room_view.ViewModel.TareaViewModel
import com.example.ejemplo_room_view.ViewModel.TareaViewModelFactory

class MainActivity : AppCompatActivity() {

    private val tareaViewModel: TareaViewModel  by viewModels{
        TareaViewModelFactory((application as TareaAppplication).repositorio)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adaptador=TareaListaAdapter()

        recyclerView.adapter=adaptador

        recyclerView.layoutManager = LinearLayoutManager(this)

        tareaViewModel.listaTareas.observe(this, Observer { tareas ->
            tareas?.let { adaptador.submitList(it) }
        })
    }
}