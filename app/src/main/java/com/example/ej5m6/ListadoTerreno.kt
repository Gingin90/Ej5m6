package com.example.ej5m6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.ej5m6.databinding.FragmentListadoTerrenoBinding
import com.example.ej5m6.presentation.Adapter
import com.example.ej5m6.presentation.TerrenoVM


class ListadoTerreno : Fragment() {
    lateinit var binding : FragmentListadoTerrenoBinding
    private val terrenoVM :TerrenoVM by  activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListadoTerrenoBinding.inflate(layoutInflater,container, false)

        binding.btnCargar.setOnClickListener {
            initAdapter()
            terrenoVM.getAllTerreno()
        }

        return binding.root
    }

    private fun initAdapter() {
       val adapter = Adapter()
        binding.recyclerTerreno.adapter= adapter
        terrenoVM.terrenosLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }

    }
}