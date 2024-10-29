package com.example.individual_2_modulo_6



    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView

class ConsumoAdapter(private var consumos: List<Consumo>) : RecyclerView.Adapter<ConsumoAdapter.ConsumoViewHolder>() {

        class ConsumoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nombreItem: TextView = itemView.findViewById(R.id.tv_nombre_item)
            val precioUnitario: TextView = itemView.findViewById(R.id.tv_precio_unitario)
            val cantidad: TextView = itemView.findViewById(R.id.tv_cantidad)
            val total: TextView = itemView.findViewById(R.id.tv_total)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsumoViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_consumo, parent, false)
            return ConsumoViewHolder(view)
        }

        override fun onBindViewHolder(holder: ConsumoViewHolder, position: Int) {
            val consumo = consumos[position]
            holder.nombreItem.text = consumo.nombreItem
            holder.precioUnitario.text = "Precio: ${consumo.precioUnitario}€"
            holder.cantidad.text = "Cantidad: ${consumo.cantidad}"
            holder.total.text = "Total: ${consumo.calcularTotal()}€"
        }

        override fun getItemCount(): Int = consumos.size

        fun setDatos(nuevosConsumos: List<Consumo>) {
            this.consumos = nuevosConsumos
            notifyDataSetChanged()
        }
    }
