package com.example.ejemplo_room_view.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.ejemplo_room_view.Entidades.Tarea
import com.example.ejemplo_room_view.Repositorio.TareaRepositorio
import kotlinx.coroutines.launch

class TareaViewModel (private val repositorio: TareaRepositorio):ViewModel() {
    val listaTareas: LiveData<List<Tarea>> =repositorio.listaTareas.asLiveData()

    //Corrutina para almacenar los datos mediante una
    // operación asíncrona de manera segura y vinculada al ciclo de vida de un ViewModel.
    // Se emplea viewModelScope.launch
    fun insertar(tarea: Tarea) =viewModelScope.launch {
        repositorio.insert(tarea)
    }
}
//Mediante la siguiente clase creamos instancias de ViewModel
// Debe tener el método create para crear dichas instancias
class TareaViewModelFactory(private val repositorio: TareaRepositorio):ViewModelProvider.Factory{
    override fun <T:ViewModel> create(modelClass: Class<T>):T{
        if (modelClass.isAssignableFrom(TareaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TareaViewModel(repositorio) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}