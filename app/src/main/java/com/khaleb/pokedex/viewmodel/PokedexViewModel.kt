package com.khaleb.pokedex.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khaleb.pokedex.model.Pokemons
import com.khaleb.pokedex.model.repository.RepositoryPokedex
import kotlinx.coroutines.launch

class PokedexViewModel(
    private var repositoryPokedex: RepositoryPokedex
) : ViewModel() {

    var warPets = MutableLiveData<Pokemons>()
    var _warPets : LiveData<Pokemons> = warPets

    fun fetchData(context : Context){
        viewModelScope.launch {
            warPets.value =
                repositoryPokedex.fetchNetworkData()?.get(2)

            if(warPets.value != null){
                Toast.makeText(context, " foi", Toast.LENGTH_LONG).show()
            }
        }
    }
}