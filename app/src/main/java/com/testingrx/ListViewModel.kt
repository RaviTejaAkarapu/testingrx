package com.testingrx

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel() {

    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading =  MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        val mockData = listOf(Country("countryA"),
            Country("countryB"),
            Country("countryC"),
            Country("countryD"),
            Country("countryE"),
            Country("countryF"),
            Country("countryG"),
            Country("countryH"),
            Country("countryI"),
            Country("countryJ"),
            Country("countryK")
            )

        countryLoadError.value = false
        loading.value = false
        countries.value = mockData
    }
}