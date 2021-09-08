package com.khaleb.pokedex.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khaleb.pokedex.R
import com.khaleb.pokedex.databinding.LayoutIconRecyclerBinding
import com.khaleb.pokedex.model.Pokemon

class PokedexAdapter(
    var context: Context
) : RecyclerView.Adapter<PokedexAdapter.ViewHolder>() {

    var teste = ArrayList<Pokemon>()

    class ViewHolder(view: LayoutIconRecyclerBinding) : RecyclerView.ViewHolder(view.root) {
        val binding = LayoutIconRecyclerBinding.bind(view.root)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexAdapter.ViewHolder {
        val bind = LayoutIconRecyclerBinding.inflate(LayoutInflater.from(context), parent, false)
        return PokedexAdapter.ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: PokedexAdapter.ViewHolder, position: Int) {

        setView(holder, position)
        clickItem(holder.binding.materialCardIcon, position)


    }

    override fun getItemCount(): Int {
        return teste.size ?: 0
    }

    fun update(pokeList: List<Pokemon>) {
        teste.addAll(pokeList)
        notifyDataSetChanged()
    }


    private fun setView(holder : ViewHolder, position: Int){
        holder.binding.imgTypeFire.visibility = View.GONE
        holder.binding.imgTypeNormal.visibility = View.GONE
        holder.binding.imgTypeWater.visibility = View.GONE

        holder.binding.txtName.text = teste[position].name
        holder.binding.txtId.text = teste[position].id

        Glide.with(context)
            .load(teste[position].imageurl)
            .into(holder.binding.imgPokemon)

        when (teste[position].typeofpokemon.size) {
            1 -> PokemonUIDetails().checkPokemonType(holder.binding.imgTypeWater, teste[position].typeofpokemon[0])
            2 -> {
                PokemonUIDetails().checkPokemonType(holder.binding.imgTypeWater, teste[position].typeofpokemon[0])
                PokemonUIDetails().checkPokemonType(holder.binding.imgTypeFire, teste[position].typeofpokemon[1])
            }
            3 -> {
                PokemonUIDetails().checkPokemonType(holder.binding.imgTypeWater, teste[position].typeofpokemon[0])
                PokemonUIDetails().checkPokemonType(holder.binding.imgTypeFire, teste[position].typeofpokemon[1])
                PokemonUIDetails().checkPokemonType(holder.binding.imgTypeNormal, teste[position].typeofpokemon[2])
            }
            else -> {}
        }
    }

    private fun clickItem(view : View, position : Int){
        view.setOnClickListener {
            Toast.makeText(context, teste[position].name, Toast.LENGTH_LONG).show()
            val bundle = bundleOf("position" to position)
            view.findNavController().navigate(R.id.action_mainFragment_to_descriptionFragment, bundle)
        }
    }
}