//package com.example.marlon.pokeapiclientchallenge.dao
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.example.marlon.pokeapiclientchallenge.model.Pokemon
//
//@Dao
//interface PokemonDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertPokemon(pokemon: Pokemon?)
//
//    @Query("SELECT * from Pokemon")
//    suspend fun getAllPokemon(): List<Pokemon>?
//
//    @Query("DELETE from Pokemon WHERE name LIKE :name")
//    suspend fun deletePokemon(name:String)
//}