package com.poly.assigment_kotlin.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poly.assigment_kotlin.Model.Interior
import com.poly.assigment_kotlin.services.RetrofitServices
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InteriorViewModel: ViewModel() {
    val interior  = MutableLiveData<List<Interior>>()
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
}