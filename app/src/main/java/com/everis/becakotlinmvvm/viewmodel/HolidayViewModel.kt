package com.everis.becakotlinmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.everis.becakotlinmvvm.api.HolidayRestApiTask
import com.everis.becakotlinmvvm.data.HolidayRepository
import com.everis.becakotlinmvvm.domain.Holiday
import com.everis.becakotlinmvvm.implementations.HolidayDataSourceImplementation
import com.everis.becakotlinmvvm.usecase.HolidayListUseCase

class HolidayViewModel: ViewModel() {


    private val holidayRestApiTask = HolidayRestApiTask()
    private val holidayDataSource = HolidayDataSourceImplementation(holidayRestApiTask)
    private val holidayRepository = HolidayRepository(holidayDataSource)
    private val holidayListUseCase = HolidayListUseCase(holidayRepository)

    private var mutableLiveData: MutableLiveData<List<Holiday>>? = null

    init {
        getHolidays()
    }

    fun getHolidays(): LiveData<List<Holiday>> {
        if (mutableLiveData == null) {
            mutableLiveData = holidayListUseCase.invoke()
        }

        return mutableLiveData!!
    }

}