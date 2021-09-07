package com.khaleb.pokedex.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khaleb.pokedex.model.Pokemon
import com.khaleb.pokedex.model.repository.RepositoryPokedex
import kotlinx.coroutines.launch

class PokedexViewModel(
    private var repositoryPokedex: RepositoryPokedex
) : ViewModel() {

    var warPets = MutableLiveData<List<Pokemon>>()
    var _warPets : LiveData<List<Pokemon>> = warPets

    fun fetchData(context : Context){
        viewModelScope.launch {
            if(warPets.value == null){
                warPets.value = repositoryPokedex.fetchNetworkData()
                Toast.makeText(context, warPets.value!![0].name, Toast.LENGTH_LONG).show()
            }
        }
    }


}