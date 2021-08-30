package com.khaleb.pokedex.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khaleb.pokedex.databinding.LayoutIconRecyclerBinding
import com.khaleb.pokedex.model.Pokemon

class PokedexAdapter(
    var context : Context
)  : RecyclerView.Adapter<PokedexAdapter.ViewHolder>() {

    var teste = ArrayList<Pokemon>()

    class ViewHolder(view: LayoutIconRecyclerBinding) : RecyclerView.ViewHolder(view.root){
        val binding = LayoutIconRecyclerBinding.bind(view.root)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexAdapter.ViewHolder {
        val bind = LayoutIconRecyclerBinding.inflate(LayoutInflater.from(context), parent, false)
        return PokedexAdapter.ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: PokedexAdapter.ViewHolder, position: Int) {
        holder.binding.txtName.text = teste[position].name
        holder.binding.txtId.text = teste[position].id

        Glide.with(context)
            .load(teste[position].imageurl)
            .into(holder.binding.imgPokemon)


    }

    override fun getItemCount(): Int {
        return teste.size ?: 0
    }

    fun update(pokeList : List<Pokemon>){
        teste.addAll(pokeList)
        notifyDataSetChanged()
    }
}