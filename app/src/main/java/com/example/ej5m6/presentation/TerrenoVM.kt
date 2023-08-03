package com.example.ej5m6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ej5m6.data.Repositorio
import com.example.ej5m6.data.remote.Terreno
import com.example.ej5m6.data.remote.TerrrenoRetroFit
import kotlinx.coroutines.launch


class TerrenoVM(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio
    val terrenoLiveData= MutableLiveData<List<Terreno>>()

    init {
        val api = TerrrenoRetroFit.getRetrofitClient()
        repositorio = Repositorio(api)
    }
    fun getAllTerreno() = viewModelScope.launch {
        terrenoLiveData.value=repositorio.cargarTerreno()

    }
}