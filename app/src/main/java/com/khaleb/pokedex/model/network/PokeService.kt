package com.khaleb.pokedex.model.network

import com.khaleb.pokedex.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET

interface PokeService {

    @GET("pokemon.json")
    suspend fun fetchData() : Response<List<Pokemon>>
}