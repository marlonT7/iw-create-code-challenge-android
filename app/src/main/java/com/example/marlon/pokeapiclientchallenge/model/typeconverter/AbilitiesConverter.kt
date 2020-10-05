//package com.example.marlon.pokeapiclientchallenge.model.typeconverter
//
//import Abilities
//import androidx.room.TypeConverter
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import java.lang.reflect.Type
//
//class AbilitiesConverter {
//
//    @TypeConverter
//    fun fromAbilities(abilities: ArrayList<Abilities?>?): String? {
//        val gson = Gson()
//        val type = object : TypeToken<ArrayList<Abilities?>?>() {}.type
//        return gson.toJson(abilities, type)
//    }
//
//    @TypeConverter
//    fun toAbilities(abilitiesString: String?): ArrayList<Abilities?>? {
//        val gson = Gson()
//        val type: Type = object : TypeToken<ArrayList<Abilities?>?>() {}.type
//        return gson.fromJson(abilitiesString, type)
//    }
//}
