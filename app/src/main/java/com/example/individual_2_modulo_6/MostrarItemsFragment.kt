package com.example.individual_2_modulo_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.individual_2_modulo_6.databinding.FragmentMostrarItemsBinding

class MostrarItemsFragment : Fragment() {
    private lateinit var viewModel: ConsumoViewModel
    private lateinit var binding: FragmentMostrarItemsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMostrarItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity()).get(ConsumoViewModel::class.java)

        viewModel.consumptions.observe(viewLifecycleOwner) { consumos ->
            // Actualiza tu vista con los consumos
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            binding.recyclerView.adapter = ConsumptionsAdapter(consumos) // Asumiendo que tienes un RecyclerView y un adapter
        }

        viewModel.fetchConsumptions()
    }
}
