package com.example.ejemplo_room_view.Utils

import android.app.Application
import com.example.ejemplo_room_view.Repositorio.TareaRepositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class TareaAppplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { TareaRoomDatabase.getDatabase(this, applicationScope)}
    val repositorio by lazy {TareaRepositorio(database.TareaDao())}
}

/*
Creaste una instancia de base de datos.
Creaste una instancia de repositorio en función del DAO de la base de datos.
Dado que estos objetos deberían crearse únicamente cuando se los necesita por primera vez y no al iniciar la app, usaste la delegación de propiedades de Kotlin: by lazy.
Ahora que creaste la clase Application, actualiza el archivo AndroidManifest y configura WordsApplication como application android:name.
*/
