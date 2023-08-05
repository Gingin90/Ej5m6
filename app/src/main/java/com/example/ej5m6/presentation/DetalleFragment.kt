package com.example.ej5m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ej5m6.R
import com.example.ej5m6.databinding.FragmentDetalleBinding

private const val ARG_PARAM1 = "id"

class DetalleFragment : Fragment() {

    lateinit var binding : FragmentDetalleBinding
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetalleBinding.inflate(layoutInflater,container,false)
        binding.tvID.text=param1
        return binding.root
        }


    }
