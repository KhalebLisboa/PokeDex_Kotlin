package com.khaleb.pokedex.view

import android.view.View
import android.widget.ImageView
import com.khaleb.pokedex.R

class PokemonUIDetails() {
    fun checkPokemonType(view: ImageView, type: String) {
        when (type) {
            "Fire" -> {
                view.setImageResource(R.drawable.ic_type_fire)
                view.visibility = View.VISIBLE
            }
            "Water" -> {
                view.setImageResource(R.drawable.ic_type_water)
                view.visibility = View.VISIBLE
            }
            "Grass" -> {
                view.setImageResource(R.drawable.ic_type_grass)
                view.visibility = View.VISIBLE
            }
            "Psychic" -> {
                view.setImageResource(R.drawable.ic_type_psychic)
                view.visibility = View.VISIBLE
            }
            "Poison" -> {
                view.setImageResource(R.drawable.ic_type_poison)
                view.visibility = View.VISIBLE
            }
            "Flying" -> {
                view.setImageResource(R.drawable.ic_type_flying)
                view.visibility = View.VISIBLE
            }
            "Rock" -> {
                view.setImageResource(R.drawable.ic_type_rock)
                view.visibility = View.VISIBLE
            }
            "Fighting" -> {
                view.setImageResource(R.drawable.ic_type_fighting)
                view.visibility = View.VISIBLE
            }
            "Electric" -> {
                view.setImageResource(R.drawable.ic_type_electric)
                view.visibility = View.VISIBLE
            }
            "Ground" -> {
                view.setImageResource(R.drawable.ic_type_ground)
                view.visibility = View.VISIBLE
            }
            "Steel" -> {
                view.setImageResource(R.drawable.ic_type_steel)
                view.visibility = View.VISIBLE
            }
            "Normal" -> {
                view.setImageResource(R.drawable.ic_type_normal)
                view.visibility = View.VISIBLE
            }
            else -> view.visibility = View.GONE
        }
    }
}

