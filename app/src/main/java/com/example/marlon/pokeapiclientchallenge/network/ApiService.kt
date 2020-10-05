package com.example.marlon.pokeapiclientchallenge.network


import com.example.marlon.pokeapiclientchallenge.model.Pokemon
import com.example.marlon.pokeapiclientchallenge.model.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Show pokemon list
    @GET("pokemon/")
    suspend fun getPokemonList(
        @Query("limit") pageLimit: String = "20", @Query("offset") offset:String ="0"
    ): PokemonList?

    // Get the pokemon info
    @GET("pokemon/{name}/")
    suspend fun getPokemonByName(@Path("name") pokemonName: String?): Pokemon?
}