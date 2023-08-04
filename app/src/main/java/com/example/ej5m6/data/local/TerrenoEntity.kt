package com.example.ej5m6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "tabla_terreno")
    data class TerrenoEntity(@PrimaryKey val id :String, val price:Int, val type:String, val img:String){

}