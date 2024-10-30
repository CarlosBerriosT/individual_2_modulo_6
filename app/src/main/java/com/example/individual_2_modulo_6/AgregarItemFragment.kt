package com.example.individual_2_modulo_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.individual_2_modulo_6.databinding.FragmentAgregarItemBinding

class AgregarItemFragment : Fragment() {
    private lateinit var viewModel: ConsumoViewModel
    private lateinit var binding: FragmentAgregarItemBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAgregarItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity()).get(ConsumoViewModel::class.java)

        binding.btnAgregar.setOnClickListener {
            val nombre = binding.etNombreItem.text.toString()
            val precio = binding.etPrecioUnitario.text.toString().toDoubleOrNull() ?: 0.0
            val cantidad = binding.etCantidad.text.toString().toIntOrNull() ?: 0

            if (nombre.isNotEmpty() && cantidad > 0 && precio > 0) {
                val consumo = Consumo(nombreItem = nombre, precioUnitario = precio, cantidad = cantidad)
                viewModel.addConsumo(consumo)
                findNavController().navigate(R.id.action_AgregarItemFragment_to_MostrarItemsFragment)
            } else {
                Toast.makeText(requireContext(), "Por favor, llena todos los campos correctamente.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
