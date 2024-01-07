package com.example.ejemplo_room_view.Utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ejemplo_room_view.Dao.TareaDao
import com.example.ejemplo_room_view.Entidades.Tarea
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Tarea::class), version = 1, exportSchema = false)
public abstract class TareaRoomDatabase : RoomDatabase() {


    abstract fun TareaDao() : TareaDao

    //Para inicializar valores en la BD
    private class TareaDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var tareaDao = database.TareaDao()

                    // Delete all content here.
                    tareaDao.eliminarTodos()

                    // Add sample words.
                    var tarea = Tarea(1,"Estudiar",3)
                    tareaDao.insertar(tarea)
                    var tarea2 = Tarea(2,"Descansar",3)
                    tareaDao.insertar(tarea2)

                }
            }
        }
    }


    companion object{
        //Singleton para evitar múltiples instancias de apertura de la base de datos
        @Volatile
        private var INSTANCE : TareaRoomDatabase? =null

        fun getDatabase(context: Context, scope:CoroutineScope) : TareaRoomDatabase{
            // Si la instancia no es null, se devuelve, en caso contrario se crea
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TareaRoomDatabase::class.java,
                    "tareas_database"
                )
                .addCallback(TareaDatabaseCallback(scope))
                .build()
                INSTANCE=instance

                instance
            }
        }
    }
}