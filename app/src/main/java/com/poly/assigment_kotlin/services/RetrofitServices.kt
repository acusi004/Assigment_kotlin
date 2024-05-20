package com.poly.assigment_kotlin.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServices {
    private  val BASE_URL = "https://65dae5d53ea883a15290dd1b.mockapi.io/"

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val interiorServices :InteriorServices by lazy {
        retrofit.create(InteriorServices::class.java)
    }
}