package com.example.ej5m6.data

import com.example.ej5m6.data.remote.Terreno
import com.example.ej5m6.data.remote.TerrenoAPI

class Repositorio( private val terrenoAPI: TerrenoAPI) {

     suspend fun cargarTerreno():List<Terreno>{
      return.terrenoAPI.getData()
     }


}