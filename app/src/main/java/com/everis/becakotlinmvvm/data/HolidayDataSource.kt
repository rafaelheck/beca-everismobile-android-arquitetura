package com.everis.becakotlinmvvm.data

import com.everis.becakotlinmvvm.domain.Holiday

interface HolidayDataSource {

    fun getAllHolidays(): List<Holiday>
}