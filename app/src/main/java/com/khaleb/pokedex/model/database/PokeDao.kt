package com.khaleb.pokedex.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.khaleb.pokedex.model.Pokemon

@Dao
interface PokeDao {

    @Insert
    fun saveData(pokemons : List<Pokemon>)

    @Query("SELECT * FROM pokemon")
    fun fetchData() : List<Pokemon>

}