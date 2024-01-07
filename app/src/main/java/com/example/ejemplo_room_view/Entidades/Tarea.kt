package com.example.ejemplo_room_view.Entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "tarea_tabla")
class Tarea (
    @PrimaryKey (autoGenerate = true)
    @NotNull
    val id:Int,
    @NotNull
    val nombre:String,
    @ColumnInfo( name="importancia")
    val prioridad: Int){}