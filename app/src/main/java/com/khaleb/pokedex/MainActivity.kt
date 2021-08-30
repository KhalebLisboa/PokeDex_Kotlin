package com.khaleb.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.khaleb.pokedex.databinding.ActivityMainBinding
import com.khaleb.pokedex.model.repository.RepositoryPokedex
import com.khaleb.pokedex.viewmodel.PokedexViewModel
import com.khaleb.pokedex.viewmodel.PokedexViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var view : View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)

    }
}