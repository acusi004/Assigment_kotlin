package com.poly.assigment_kotlin.Model

data class Cart(
    val id: Int,
    val image:String,
    val name: String,
    val price: Int,
    val quantity: Int,
    val total: Int
)
