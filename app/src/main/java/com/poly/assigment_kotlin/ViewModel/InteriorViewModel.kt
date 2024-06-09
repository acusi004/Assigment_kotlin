package com.poly.assigment_kotlin.ViewModel

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poly.assigment_kotlin.Model.Cart
import com.poly.assigment_kotlin.Model.Interior
import com.poly.assigment_kotlin.services.RetrofitServices
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InteriorViewModel: ViewModel() {
    val interior  = MutableLiveData<List<Interior>>()
    val cart  = MutableLiveData<List<Cart>>()
    val errorMessage = MutableLiveData<String>()


    fun getInterior(){
        viewModelScope.launch {
           val retrofitServices = RetrofitServices.interiorServices
            retrofitServices.getListInterior().enqueue(object : Callback<List<Interior>>{
                override fun onResponse(
                    call: Call<List<Interior>>,
                    response: Response<List<Interior>>
                ) {
                    if (response.isSuccessful){
                        interior.postValue(response.body())
                    }else{
                        errorMessage.postValue("error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<Interior>>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
        }
    }

    fun addCart(id: Int, image: String, name: String, price: Int,quantity: Int){
        val _addToCartResult = MutableLiveData<Result<Unit>>()

        viewModelScope.launch {
            try{
                val retrofitService = RetrofitServices.interiorServices
                retrofitService.addCart(Cart(id, image, name, price, quantity))
                _addToCartResult.value = Result.success(Unit)
                Log.d("CartViewModel", "Product added to cart successfully")
            }catch (err: Exception){
                errorMessage.postValue(err.message)
            }

            getCart()
        }
    }
    fun getCart(){
        viewModelScope.launch {
            val retrofitServices = RetrofitServices.interiorServices
            retrofitServices.getListCart().enqueue(object : Callback<List<Cart>>{
                override fun onResponse(call: Call<List<Cart>>, response: Response<List<Cart>>) {
                   if(response.isSuccessful){
                       cart.postValue(response.body())
                   }else{
                       errorMessage.postValue("error: ${response.code()}")
                   }
                }

                override fun onFailure(call: Call<List<Cart>>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }

            })
        }
    }
}

