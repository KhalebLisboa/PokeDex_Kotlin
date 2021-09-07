package com.khaleb.pokedex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.khaleb.pokedex.databinding.FragmentMainBinding
import com.khaleb.pokedex.model.Pokemon
import com.khaleb.pokedex.model.repository.RepositoryPokedex
import com.khaleb.pokedex.viewmodel.PokedexViewModel
import com.khaleb.pokedex.viewmodel.PokedexViewModelFactory

class MainFragment : Fragment() {

    private lateinit var mFragment: FragmentMainBinding
    private lateinit var viewModel: PokedexViewModel
    private lateinit var adapter: PokedexAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mFragment = FragmentMainBinding.inflate(layoutInflater)
        return mFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repo = RepositoryPokedex()
        val vmFactory = PokedexViewModelFactory(repo)
        viewModel = ViewModelProvider(requireActivity(), vmFactory)[PokedexViewModel::class.java]

        fetchData()
        setupObservers()

        adapter = PokedexAdapter(requireContext())
        mFragment.recyclerMain.adapter = adapter

    }

    private fun fetchData() = viewModel.fetchData(requireContext())

    private fun setupObservers() {
        viewModel.warPets.observe(viewLifecycleOwner, {
            adapter.update(it)
        })
    }
}