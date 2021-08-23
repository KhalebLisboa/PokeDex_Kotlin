package com.khaleb.pokedex.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pokemon(
    @PrimaryKey
    var id : String,
    var name : String,
    var imageurl : String,
    var xdescription : String,
    var category : String,
    var typeofpokemon : List<String>,
    var evolutions : List<String>,
    var abilities : List<String>,
    var hp : Int,
    var attack : Int,
    var defense : Int,
    var total : Int
)