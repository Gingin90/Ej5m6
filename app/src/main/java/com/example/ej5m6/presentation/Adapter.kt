package com.example.ej5m6.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ej5m6.R
import com.example.ej5m6.data.local.TerrenoEntity
import com.example.ej5m6.databinding.ItemTerrenoBinding

class Adapter : RecyclerView.Adapter<Adapter.ItemTerrenoViewHolder>() {

    lateinit var binding: ItemTerrenoBinding
    private val listItemTerreno = mutableListOf<TerrenoEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemTerrenoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemTerreno.size
    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val terreno = listItemTerreno[position]
        holder.bind(terreno)
    }

    fun setData(terreno: List<TerrenoEntity>) {
        this.listItemTerreno.clear()
        this.listItemTerreno.addAll(terreno)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val v: ItemTerrenoBinding) : RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: TerrenoEntity) {
            v.imgTerreno.load(terreno.img)
            v.imgTerreno.setOnClickListener {

                val bundle = Bundle()
                bundle.putString("id", terreno.id)
                bundle.putString("imagen", terreno.img)
                bundle.putString("precio", terreno.price.toString())
                Navigation.findNavController(v.root)
                    .navigate(R.id.action_listadoTerreno_to_detalleFragment, bundle)

            }

        }

    }
}