package com.example.marlon.pokeapiclientchallenge.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class Api {
    companion object {
        private const val DOMAIN = "pokeapi.co"
        private const val BASE_URL = "https://pokeapi.co/api/v2/"
        private var retrofit: Retrofit? = null
        fun getApi(): Retrofit? {
            // Create the retrofit client for request and read the json
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        // Return true if the connection is available
        fun isAvailable(): Boolean {
            val runtime = Runtime.getRuntime()
            try {
                val ipProcess = runtime.exec("/system/bin/ping -c 1 -w 500 $DOMAIN")
                val exitValue = ipProcess.waitFor()
                return exitValue == 0
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return false
        }
    }
}