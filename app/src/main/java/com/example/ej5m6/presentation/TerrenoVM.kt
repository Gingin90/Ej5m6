package com.example.ej5m6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ej5m6.data.Repositorio
import com.example.ej5m6.data.local.TerrenoDao
import com.example.ej5m6.data.local.TerrenoDatabase
import com.example.ej5m6.data.remote.Terreno
import com.example.ej5m6.data.remote.TerrenoAPI
import com.example.ej5m6.data.remote.TerrrenoRetroFit
import kotlinx.coroutines.launch


class TerrenoVM(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio

    fun terrenosLiveData()= repositorio.obtenerTerrenos()

    init {
        val api :TerrenoAPI = TerrrenoRetroFit.getRetrofitClient()
        val terrenoDatabase: TerrenoDao = TerrenoDatabase.getDataBase(application).getITerrenoDao()
        repositorio = Repositorio(api,terrenoDatabase)
    }
    fun getAllTerreno() = viewModelScope.launch {
        repositorio.cargarTerreno()

    }
}