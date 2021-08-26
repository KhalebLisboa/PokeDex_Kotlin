package com.khaleb.pokedex.model.repository

import com.khaleb.pokedex.model.Pokemon
import com.khaleb.pokedex.model.network.PokemonAPI

class RepositoryPokedex() {

    suspend fun fetchNetworkData() : List<Pokemon>? {
        return PokemonAPI().service().fetchData().body()
    }


}