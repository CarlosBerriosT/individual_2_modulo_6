package com.example.individual_2_modulo_6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.individual_2_modulo_6.databinding.ItemConsumoBinding

class ConsumptionsAdapter(private val consumos: List<Consumo>) : RecyclerView.Adapter<ConsumptionsAdapter.ConsumoViewHolder>() {

    class ConsumoViewHolder(private val binding: ItemConsumoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(consumo: Consumo) {
            binding.tvNombreItem.text = consumo.nombreItem
            binding.tvPrecioUnitario.text = consumo.precioUnitario.toString()
            binding.tvCantidad.text = consumo.cantidad.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsumoViewHolder {
        val binding = ItemConsumoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConsumoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConsumoViewHolder, position: Int) {
        holder.bind(consumos[position])
    }

    override fun getItemCount(): Int {
        return consumos.size
    }
}
