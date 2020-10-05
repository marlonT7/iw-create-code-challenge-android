//package com.example.marlon.pokeapiclientchallenge.model.typeconverter
//
//import Stats
//import androidx.room.TypeConverter
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import java.lang.reflect.Type
//
//class StatsConverter {
//    @TypeConverter
//    fun fromStats(stats: ArrayList<Stats?>?): String? {
//        val gson = Gson()
//        val type = object : TypeToken<ArrayList<Stats?>?>() {}.type
//        return gson.toJson(stats, type)
//    }
//
//   @TypeConverter
//    fun toStats(statsString: String?): ArrayList<Stats?>? {
//        val gson = Gson()
//        val type: Type = object : TypeToken<ArrayList<Stats?>?>() {}.type
//        return gson.fromJson(statsString, type)
//    }
//}