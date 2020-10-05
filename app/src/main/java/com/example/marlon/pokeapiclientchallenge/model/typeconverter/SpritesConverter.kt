//package com.example.marlon.pokeapiclientchallenge.model.typeconverter
//
//import Sprites
//import androidx.room.TypeConverter
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import java.lang.reflect.Type
//
//class SpritesConverter {
//    companion object {
//        @TypeConverter
//        @JvmStatic
//        fun fromSprites(sprites: Sprites?): String? {
//            val gson = Gson()
//            val type = object : TypeToken<Sprites?>() {}.type
//            return gson.toJson(sprites, type)
//        }
//
//        @TypeConverter
//        @JvmStatic
//        fun toSprites(spritesString: String?): Sprites? {
//            val gson = Gson()
//            val type: Type = object : TypeToken<Sprites?>() {}.type
//            return gson.fromJson(spritesString, type)
//        }
//    }
//
//}