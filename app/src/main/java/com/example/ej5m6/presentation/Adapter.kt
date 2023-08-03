package com.example.ej5m6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ej5m6.data.remote.Terreno
import com.example.ej5m6.databinding.ItemTerrenoBinding

class Adapter : RecyclerView.Adapter<Adapter.ItemTerrenoViewHolder>() {

lateinit var  binding : ItemTerrenoBinding
private val listItemTerreno = mutableListOf<Terreno>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
    binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemTerrenoViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return listItemTerreno.size
    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
     val terreno= listItemTerreno[position]
        holder.bind(terreno)
    }
   fun  setData(terreno: List<Terreno>){
       this.listItemTerreno.clear()
       this.listItemTerreno.addAll(terreno)
       notifyDataSetChanged()
   }
    class ItemTerrenoViewHolder(val v:ItemTerrenoBinding):RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: Terreno) {
            v.imgTerreno.load(terreno.img)

        }

    }
}