package com.example.ejemplo_room_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplo_room_view.Adaptadores.TareaListaAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adaptador=TareaListaAdapter()

        recyclerView.adapter=adaptador

        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}