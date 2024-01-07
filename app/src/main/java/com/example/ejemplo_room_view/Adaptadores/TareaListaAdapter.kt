package com.example.ejemplo_room_view.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplo_room_view.Entidades.Tarea
import com.example.ejemplo_room_view.R


class TareaListaAdapter : ListAdapter<Tarea, TareaListaAdapter.ViewHolder>(TareaComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         return ViewHolder.create(parent)
     }




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val current = getItem(position)
         holder.bind(current.nombre)
        // holder.itemView.setOnClickListener{}
     }

     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         private val tareaItemView: TextView = itemView.findViewById(R.id.textView)

         fun bind(text: String?) {
             tareaItemView.text = text
         }

         companion object {
             fun create(parent: ViewGroup): ViewHolder {
                 val view: View = LayoutInflater.from(parent.context)
                     .inflate(R.layout.recyclerview_item, parent, false)
                 return ViewHolder(view)
             }
         }
     }

     class TareaComparator : DiffUtil.ItemCallback<Tarea>() {
         override fun areItemsTheSame(oldItem: Tarea, newItem: Tarea): Boolean {
             return oldItem === newItem
         }

         override fun areContentsTheSame(oldItem: Tarea, newItem: Tarea): Boolean {
             return oldItem.equals(newItem)
         }
     }
}

