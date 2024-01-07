package com.example.ejemplo_room_view.Repositorio

import androidx.annotation.WorkerThread
import com.example.ejemplo_room_view.Dao.TareaDao
import com.example.ejemplo_room_view.Entidades.Tarea
import kotlinx.coroutines.flow.Flow

//El atributo es de tipo DAO, porque es la estructura que necesitas para acceder a la base de datos
class TareaRepositorio (private val tareaDao: TareaDao) {
    // Room va a ejecutar todas las queries en hilos separados
    // El observador Flow indica si se han producido cambios

    val listaTareas: Flow<List<Tarea>> = tareaDao.obtenerTareaOrdenada()

    //Por defecto, Room ejecuta consultas suspendidas fuera del hilo principal; por lo tanto, no necesitamos implementar nada más para garantizar que no estamos realizando trabajos prolongados en la base de datos fuera del hilo principal
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(tarea: Tarea){
        tareaDao.insertar(tarea)
    }

}