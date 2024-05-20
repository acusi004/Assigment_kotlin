package com.poly.assigment_kotlin.services


import com.poly.assigment_kotlin.Model.Interior
import retrofit2.Call
import retrofit2.http.GET

interface InteriorServices {
    @GET("Product")
    fun getListInterior(): Call<List<Interior>>
}