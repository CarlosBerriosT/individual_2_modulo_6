package com.example.individual_2_modulo_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MostrarItemsFragment : Fragment() {
    private lateinit var viewModel: ConsumoViewModel
    private lateinit var tvConsumos: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mostrar_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ConsumoViewModel::class.java)
        tvConsumos = view.findViewById(R.id.tv_consumos)

        viewModel.todosLosConsumos.observe(viewLifecycleOwner, Observer { consumos ->
            val builder = StringBuilder()
            consumos.forEach { consumo ->
                builder.append("${consumo.nombreItem}: ${consumo.calcularTotal()}\n")
            }
            tvConsumos.text = builder.toString()
        })
    }
}
