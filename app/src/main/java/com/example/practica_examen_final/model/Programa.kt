package com.example.practica_examen_final.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="programa")

data class Programa(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="nombrePrograma")
    val nombrePrograma:String,
    @ColumnInfo(name="descripcionPrograma")
    val descripcionPrograma:String,
    @ColumnInfo(name="hora")
    val hora:Double,
    @ColumnInfo(name="canal")
    val canal:Int,
    @ColumnInfo(name="productor")
    val productor:String
) : Parcelable