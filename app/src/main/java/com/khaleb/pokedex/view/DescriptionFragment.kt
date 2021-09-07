package com.khaleb.pokedex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.khaleb.pokedex.databinding.FragmentDescriptionBinding
import com.khaleb.pokedex.model.repository.RepositoryPokedex
import com.khaleb.pokedex.viewmodel.PokedexViewModel
import com.khaleb.pokedex.viewmodel.PokedexViewModelFactory

class DescriptionFragment : Fragment() {

    lateinit var bind : FragmentDescriptionBinding

    val viewmodel : PokedexViewModel by lazy {
        val repositoryPokedex = RepositoryPokedex()
        val factory = PokedexViewModelFactory(repositoryPokedex)
        ViewModelProvider(requireActivity(), factory)[PokedexViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentDescriptionBinding.inflate(layoutInflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.warPets.value?.get(arguments?.getInt("position")!!).let {
            bind.txtName.text = it?.name
            bind.txtId.text = it?.id

            Glide.with(requireContext())
                .load(it?.imageurl)
                .into(bind.imgPokemon)
        }

    }
}