package com.poly.assigment_kotlin.services


import com.poly.assigment_kotlin.Model.Cart
import com.poly.assigment_kotlin.Model.Interior
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface InteriorServices {
    @GET("Product")
    fun getListInterior(): Call<List<Interior>>

    @GET("Cart")
    fun getListCart(): Call<List<Cart>>

    @POST("Cart")
    fun addCart(@Body cart: Cart)
}