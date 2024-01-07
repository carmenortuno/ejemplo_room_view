package com.example.ejemplo_room_view.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ejemplo_room_view.Entidades.Tarea
import kotlinx.coroutines.flow.Flow

@Dao
interface TareaDao {
    @Query("SELECT * from tarea_tabla ORDER BY nombre ASC")
    fun obtenerTareaOrdenada(): Flow<List<Tarea>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(tarea:Tarea)
    // suspend se utiliza en el contexto de las coroutines para indicar que una función puede
    // ser suspendida y reanudada más tarde sin bloquear el hilo en el que se está ejecutando.
    // Las funciones marcadas con suspend son parte fundamental del modelo de concurrencia de
    // las coroutines y permiten escribir código asíncrono de manera más sencilla y eficiente.

    @Query("DELETE FROM tarea_tabla")
    suspend fun eliminarTodos()
}