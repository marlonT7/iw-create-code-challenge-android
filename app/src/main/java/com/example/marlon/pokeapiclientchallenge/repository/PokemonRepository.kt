package com.example.marlon.pokeapiclientchallenge.repository

import com.example.marlon.pokeapiclientchallenge.model.Pokemon
import com.example.marlon.pokeapiclientchallenge.model.PokemonList
import com.example.marlon.pokeapiclientchallenge.network.Api
import com.example.marlon.pokeapiclientchallenge.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonRepository(
//    private val pokemonDao: PokemonDao?,
    private val pokemonResponse: PokemonResponse,
    private val scope: CoroutineScope
) {
    private val client = Api.getApi()?.create(ApiService::class.java)

    interface PokemonResponse {
        fun onPokemonListSuccess(pokemons: ArrayList<Pokemon?>)
        fun onPokemonError(message: String)
    }

//    fun getFavoritePokemons(){
//        val pokemons: ArrayList<Pokemon?>? = arrayListOf()
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                pokemons?.addAll(pokemonDao?.getAllPokemon() as Collection<Pokemon?>)
//                pokemons?.let {
//                    scope.launch {
//                        pokemonResponse.onPokemonListSuccess(it)
//                    }
//                }
//            } catch (exception: Exception) {
//                scope.launch {
//                    pokemonResponse.onPokemonError(exception.message!!)
//                }
//            }
//        }
//    }

    fun getPokemons(){
        var pokemonList:PokemonList?=null
        val pokemons: ArrayList<Pokemon?>? = arrayListOf()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                pokemonList=client?.getPokemonList()
                pokemonList?.pokemonsShortInfo?.forEach {pokemonShortInfo ->
                    val pokemon =client?.getPokemonByName(pokemonShortInfo.name)
                    pokemon?.let {
                        pokemons?.add(it)
                    }
                }
                pokemons?.let {
                    scope.launch {
                        pokemonResponse.onPokemonListSuccess(it)
                    }
                }
            } catch (exception: Exception) {
                scope.launch {
                    pokemonResponse.onPokemonError(exception.message!!)
                }
            }
        }
    }

//    fun savePokemon(pokemon: Pokemon) {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                pokemonDao?.insertPokemon(pokemon)
//            } catch (exception: Exception) {
//                scope.launch {
//                    pokemonResponse.onPokemonError(exception.message!!)
//                }
//            }
//        }
//    }

}