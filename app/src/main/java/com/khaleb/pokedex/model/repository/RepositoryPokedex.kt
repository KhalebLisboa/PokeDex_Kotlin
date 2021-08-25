package com.khaleb.pokedex.model.repository

import com.khaleb.pokedex.model.Pokemons
import com.khaleb.pokedex.model.database.PokeDao
import com.khaleb.pokedex.model.network.PokeService
import com.khaleb.pokedex.model.network.PokemonAPI

class RepositoryPokedex() {

    suspend fun fetchNetworkData() : List<Pokemons>? {
        return PokemonAPI().service().fetchData().body()
    }


}