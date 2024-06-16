package com.devbrunini.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devbrunini.convidados.databinding.FragmentAllGuestsBinding
import com.devbrunini.convidados.view.adapter.GuestsAdapter
import com.devbrunini.convidados.viewmodel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {

    private var _binding: FragmentAllGuestsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AllGuestsViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?  ): View {

        viewModel = ViewModelProvider(this)[AllGuestsViewModel::class.java]

        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)

        binding.recyclerAllGuests.layoutManager = LinearLayoutManager(context)

        binding.recyclerAllGuests.adapter = GuestsAdapter()

        observe()
        viewModel.getAll()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun observe(){
        viewModel.guests.observe(viewLifecycleOwner){

        }
    }
}