package com.example.ej5m6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TerrenoDao {
    @Insert
    suspend fun  insertTerreno(terrenoEntity: TerrenoEntity)
    @Query("Select * From tabla_terreno order by id ASC")
    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>>
}