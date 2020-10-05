//package com.example.marlon.pokeapiclientchallenge.model.typeconverter
//
//import HeldItems
//import androidx.room.TypeConverter
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import java.lang.reflect.Type
//
//class HeldItemsConverter {
//
//    companion object {
//        @JvmStatic
//        @TypeConverter
//        fun fromHeldItems(heldItems: ArrayList<HeldItems?>?): String? {
//            val gson = Gson()
//            val type = object : TypeToken<ArrayList<HeldItems?>?>() {}.type
//            return gson.toJson(heldItems, type)
//        }
//        @JvmStatic
//        @TypeConverter
//        fun toHeldItems(heldItemsString: String?): ArrayList<HeldItems?>? {
//            val gson = Gson()
//            val type: Type = object : TypeToken<ArrayList<HeldItems?>?>() {}.type
//            return gson.fromJson(heldItemsString, type)
//        }
//    }
//}