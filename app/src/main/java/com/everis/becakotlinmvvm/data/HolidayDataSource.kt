package com.everis.becakotlinmvvm.data

import androidx.lifecycle.MutableLiveData
import com.everis.becakotlinmvvm.domain.Holiday

interface HolidayDataSource {

    fun getAllHolidays(): MutableLiveData<List<Holiday>>
}