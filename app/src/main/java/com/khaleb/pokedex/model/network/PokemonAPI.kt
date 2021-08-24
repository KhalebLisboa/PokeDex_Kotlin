package com.khaleb.pokedex.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonAPI() {

    private var instance: Retrofit? = null

    @JvmName("getInstance1")
    private fun getInstance(): Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/mrcsxsiq/b94dbe9ab67147b642baa9109ce16e44/raw/97811a5df2df7304b5bc4fbb9ee018a0339b8a38/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }

    fun service() : PokeService{
        return getInstance().create(PokeService::class.java)
    }
}