package com.example.individual_2_modulo_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class AgregarItemFragment : Fragment() {
    private lateinit var viewModel: ConsumoViewModel
    private lateinit var etNombreItem: EditText
    private lateinit var etPrecioUnitario: EditText
    private lateinit var etCantidad: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_agregar_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ConsumoViewModel::class.java)

        etNombreItem = view.findViewById(R.id.et_nombre_item)
        etPrecioUnitario = view.findViewById(R.id.et_precio_unitario)
        etCantidad = view.findViewById(R.id.et_cantidad)
        val btnAgregar = view.findViewById<Button>(R.id.btn_agregar_item)

        btnAgregar.setOnClickListener {
            val nombreItem = etNombreItem.text.toString()
            val precioUnitario = etPrecioUnitario.text.toString().toDoubleOrNull() ?: 0.0
            val cantidad = etCantidad.text.toString().toIntOrNull() ?: 0

            // Agregar el consumo
            viewModel.insertar(Consumo(nombreItem = nombreItem, precioUnitario = precioUnitario, cantidad = cantidad))

            // Navegar al fragmento de mostrar items
            findNavController().navigate(R.id.action_AgregarItemFragment_to_MostrarItemsFragment)
        }
    }
}
