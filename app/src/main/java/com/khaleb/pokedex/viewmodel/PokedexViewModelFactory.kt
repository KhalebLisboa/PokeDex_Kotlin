package com.khaleb.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khaleb.pokedex.model.repository.RepositoryPokedex

class PokedexViewModelFactory(
    var repositoryPokedex: RepositoryPokedex
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokedexViewModel( repositoryPokedex) as T
    }
}