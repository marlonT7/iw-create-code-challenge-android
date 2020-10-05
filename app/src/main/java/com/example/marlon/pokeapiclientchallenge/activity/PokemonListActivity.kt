package com.example.marlon.pokeapiclientchallenge.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marlon.pokeapiclientchallenge.R
import com.example.marlon.pokeapiclientchallenge.fragment.PokemonListFragment

class PokemonListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        // Creates a new fragment
        val pokemonListFragment = PokemonListFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container_layout, pokemonListFragment)
            .commit()
    }
}