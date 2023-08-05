package com.example.ej5m6.data

import androidx.lifecycle.LiveData
import com.example.ej5m6.data.local.TerrenoDao
import com.example.ej5m6.data.local.TerrenoEntity
import com.example.ej5m6.data.remote.Terreno
import com.example.ej5m6.data.remote.TerrenoAPI


class Repositorio(private val terrenoAPI: TerrenoAPI, private val terrenoDao: TerrenoDao) {


    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.obtenerTerrenos()
    suspend fun cargarTerreno() {

        val respuesta = terrenoAPI.getData()
        if (respuesta.isSuccessful) {
            val resp = respuesta.body()
            resp?.let { terrenos ->
                val terrenosEntity = terrenos.map { it.transformar() }
                terrenoDao.insertTerrenos(terrenosEntity)
            }

        }


    }

    fun getTerreno(id: String): LiveData<TerrenoEntity> = terrenoDao.getTerreno(id)


    fun Terreno.transformar(): TerrenoEntity =
        TerrenoEntity(this.id, this.price, this.type, this.img)
}






