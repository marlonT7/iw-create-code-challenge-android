package com.example.marlon.pokeapiclientchallenge.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marlon.pokeapiclientchallenge.R
import com.example.marlon.pokeapiclientchallenge.fragment.PokemonDetailFragment

class PokemonDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        // Creates a new fragment
        val pokemonDetailFragment = PokemonDetailFragment()
        // Send data to the fragment
        pokemonDetailFragment.arguments = intent.extras
        supportFragmentManager.beginTransaction()
                .replace(R.id.container_layout, pokemonDetailFragment)
                .commit()
    }
}