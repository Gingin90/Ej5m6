package com.example.ej5m6.data

import androidx.lifecycle.LiveData
import com.example.ej5m6.data.local.TerrenoDao
import com.example.ej5m6.data.local.TerrenoEntity
import com.example.ej5m6.data.remote.TerrenoAPI


class Repositorio( private val terrenoAPI: TerrenoAPI, private val terrenoDao: TerrenoDao) {


    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.obtenerTerrenos()
    suspend fun cargarTerreno() {

        val respuesta = terrenoAPI.getData()
        if (respuesta.isSuccessful) {
            val resp = respuesta.body()
            resp?.let {

            }

        }


    }}





