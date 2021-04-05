package com.everis.becakotlinmvvm.data

class HolidayRepository(private val holidayDataSource: HolidayDataSource) {

    fun getAllHolidaysFromDataSource() = holidayDataSource.getAllHolidays()

}