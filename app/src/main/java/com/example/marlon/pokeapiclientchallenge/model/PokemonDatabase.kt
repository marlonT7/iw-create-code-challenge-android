//package com.example.marlon.pokeapiclientchallenge.model
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.room.TypeConverters
//import com.example.marlon.pokeapiclientchallenge.dao.PokemonDao
//import com.example.marlon.pokeapiclientchallenge.model.typeconverter.*
//
//@Database(
//    entities = [
//        Pokemon::class
//    ], version = 1, exportSchema = false
//)
//@TypeConverters(
//    AbilitiesConverter::class,
//    HeldItemsConverter::class,
//    MovesConverter::class,
//    SpritesConverter::class,
//    StatsConverter::class
//)
//
//abstract class PokemonDatabase : RoomDatabase() {
//    abstract fun pokemonDao(): PokemonDao
//
//    companion object {
//        @Volatile
//        private var instance: PokemonDatabase? = null
//
//        fun getDatabase(
//            context: Context
//        ): PokemonDatabase? {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return instance ?: synchronized(this) {
//                instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    PokemonDatabase::class.java,
//                    "pokemon_database"
//                ).build()
//                // return instance
//                instance
//            }
//        }
//    }
//}