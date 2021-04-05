package com.everis.becakotlinmvvm.api

import com.everis.becakotlinmvvm.domain.Holiday
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("PublicHolidays/2021/br")
    fun getHolidays(): Call<List<Holiday>>
}