package com.example.ej5m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.example.ej5m6.R
import com.example.ej5m6.databinding.FragmentDetalleBinding

private const val ARG_PARAM1 = "id"

class DetalleFragment : Fragment() {

    lateinit var binding: FragmentDetalleBinding
    private var param1: String? = null
    private val terrenoVM: TerrenoVM by activityViewModels()

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
        binding = FragmentDetalleBinding.inflate(layoutInflater, container, false)
        terrenoVM.terrenoLiveData(param1.toString()).observe(viewLifecycleOwner) {
            binding.tvID.text = it.id
        }
        return binding.root
    }


}
