package com.example.ej5m6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ej5m6.data.Repositorio
import com.example.ej5m6.data.remote.RetrofitClient
import kotlinx.coroutines.launch


class TerrenoVM(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio

    init {
            val api = RetrofitClient.getRetrofitClient()
        repositorio = Repositorio(api)


    }
    fun getAlllTerreno() = viewModelScope.launch {
        repositorio.cargarTerreno()

    }
}