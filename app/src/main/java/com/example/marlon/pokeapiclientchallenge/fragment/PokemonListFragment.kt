package com.example.marlon.pokeapiclientchallenge.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marlon.pokeapiclientchallenge.R
import com.example.marlon.pokeapiclientchallenge.activity.PokemonDetailActivity
import com.example.marlon.pokeapiclientchallenge.adapter.PokemonListAdapter
import com.example.marlon.pokeapiclientchallenge.model.Pokemon
import com.example.marlon.pokeapiclientchallenge.repository.PokemonRepository
import kotlinx.android.synthetic.main.fragment_pokemon_list.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

// Show the lis of genres in a RecyclerView
class PokemonListFragment : Fragment(), PokemonRepository.PokemonResponse, PokemonListAdapter.SelectedItem {

    private lateinit var adapter: PokemonListAdapter
//    private var database: PokemonDatabase? = null
    private var pokemonRepository: PokemonRepository? = null
    var pokemons:ArrayList<Pokemon?>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        database = PokemonDatabase.getDatabase(context!!)
        pokemonRepository= PokemonRepository(
            this,
            CoroutineScope(Dispatchers.Main)
        )
        pokemonRepository?.getPokemons()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)
        val recyclerView = view.pokemonsRecycler
        adapter = PokemonListAdapter(context!!, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        return view
    }

    // Change to detail view
    override fun onItemSelected(position: Int) {
        val bundle = Bundle()
        bundle.putInt(PokemonDetailFragment.POSITION, position)
        bundle.putParcelableArrayList(PokemonDetailFragment.POKEMONS,pokemons)
        val intent = Intent(context, PokemonDetailActivity::class.java)
        intent.putExtras(bundle)
        activity?.startActivity(intent)
    }

    override fun onPokemonListSuccess(pokemons: ArrayList<Pokemon?>) {
        this.pokemons=pokemons
        adapter.setPokemons(pokemons)
    }

    override fun onPokemonError(message: String) {
        TODO("Not yet implemented")
    }
}