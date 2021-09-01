package com.khaleb.pokedex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.khaleb.pokedex.databinding.FragmentDescriptionBinding
import com.khaleb.pokedex.model.repository.RepositoryPokedex
import com.khaleb.pokedex.viewmodel.PokedexViewModel
import com.khaleb.pokedex.viewmodel.PokedexViewModelFactory

class DescriptionFragment : Fragment() {

    lateinit var bind : FragmentDescriptionBinding

    val viewmodel : PokedexViewModel by lazy {
        val repositoryPokedex = RepositoryPokedex()
        val factory = PokedexViewModelFactory(repositoryPokedex)
        ViewModelProvider(this, factory)[PokedexViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentDescriptionBinding.inflate(layoutInflater)
        val view = bind.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}