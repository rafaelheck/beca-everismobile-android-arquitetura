package com.everis.becakotlinmvvm.usecase

import com.everis.becakotlinmvvm.data.HolidayRepository

class HolidayListUseCase(private val holidayRepository: HolidayRepository) {

    operator fun invoke() = holidayRepository.getAllHolidaysFromDataSource()

}