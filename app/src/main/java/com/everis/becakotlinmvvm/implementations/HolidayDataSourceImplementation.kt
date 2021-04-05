package com.everis.becakotlinmvvm.implementations

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.everis.becakotlinmvvm.api.ApiInterface
import com.everis.becakotlinmvvm.api.HolidayRestApiTask
import com.everis.becakotlinmvvm.data.HolidayDataSource
import com.everis.becakotlinmvvm.domain.Holiday
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HolidayDataSourceImplementation(private val holidayRestApiTask: HolidayRestApiTask): HolidayDataSource {

    val TAG: String = javaClass.simpleName

    override fun getAllHolidays(): MutableLiveData<List<Holiday>> {
        val mutableList: MutableLiveData<List<Holiday>> = MutableLiveData()

        val apiInterface = holidayRestApiTask
            .holidayProvider()
            .create(ApiInterface::class.java)

        apiInterface.getHolidays().enqueue(object : Callback<List<Holiday>> {
            override fun onResponse(
                call: Call<List<Holiday>>,
                response: Response<List<Holiday>>
            ) {
                Log.e(TAG, "onResponse response=" + response.toString())

                if (response.isSuccessful) {
                    Log.e(TAG, "onResponse response.size=" + response.body()?.size)

                    if (response.body() != null && response.body()?.size!! > 0) {
                        mutableList.value = response.body()!!
                    }
                }
            }

            override fun onFailure(call: Call<List<Holiday>>, t: Throwable) {
                Log.e(TAG, "onFailure call=" + call.toString())
            }

        })

        return mutableList
    }

}