package com.everis.becakotlinmvvm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HolidayRestApiTask {
    companion object {
        const val BASE_URL = "https://date.nager.at/api/v2/"
    }

        fun holidayProvider() : Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

}