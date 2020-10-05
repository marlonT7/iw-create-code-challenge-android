package com.example.marlon.pokeapiclientchallenge.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.marlon.pokeapiclientchallenge.R
import com.example.marlon.pokeapiclientchallenge.adapter.PokemonDetailAdapter
import com.example.marlon.pokeapiclientchallenge.model.Pokemon
import com.example.marlon.pokeapiclientchallenge.repository.PokemonRepository
import kotlinx.android.synthetic.main.fragment_pokemon_detail.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class PokemonDetailFragment : Fragment(),
        PokemonRepository.PokemonResponse {
    companion object {
        const val POSITION = "position key"
        const val POKEMONS = "pokemons key"
    }

    private lateinit var adapter: PokemonDetailAdapter
    private lateinit var viewManager: LinearLayoutManager
    private var position: Int = 0

    //    private var database: PokemonDatabase? = null
    private var pokemonRepository: PokemonRepository? = null
    private var pokemons: ArrayList<Pokemon?>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(POSITION)
            pokemons = it.getParcelableArrayList(POKEMONS)
//            database = PokemonDatabase.getDatabase(context!!)
            pokemonRepository = PokemonRepository(
                    this,
                    CoroutineScope(Dispatchers.Main)
            )
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
        val recyclerView = view.pokemon_detail

        viewManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
        )

        adapter = PokemonDetailAdapter(context!!)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = viewManager
        adapter.setPokemons(pokemons)
        viewManager.scrollToPosition(position)
        // It allows the Navigation view as pages, through the recycler view
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        return view
    }

    override fun onPokemonListSuccess(pokemons: ArrayList<Pokemon?>) {}
    override fun onPokemonError(message: String) {}
}