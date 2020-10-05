package com.example.marlon.pokeapiclientchallenge.model

import com.google.gson.annotations.SerializedName

data class PokemonList (
     val count : Int,
     val next : String,
     val previous : String,
     @SerializedName("results")
     val pokemonsShortInfo : List<PokemonShortInfo>
)