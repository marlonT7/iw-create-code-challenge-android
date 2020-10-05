//package com.example.marlon.pokeapiclientchallenge.model.typeconverter
//
//import Moves
//import androidx.room.TypeConverter
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import java.lang.reflect.Type
//
//class MovesConverter {
//    companion object {
//        @JvmStatic
//        @TypeConverter
//        fun fromMoves(moves: ArrayList<Moves?>?): String? {
//            val gson = Gson()
//            val type = object : TypeToken<ArrayList<Moves?>?>() {}.type
//            return gson.toJson(moves, type)
//        }
//        @JvmStatic
//        @TypeConverter
//        fun toMoves(movesString: String?): ArrayList<Moves?>? {
//            val gson = Gson()
//            val type: Type = object : TypeToken<ArrayList<Moves?>?>() {}.type
//            return gson.fromJson(movesString, type)
//        }
//    }
//}