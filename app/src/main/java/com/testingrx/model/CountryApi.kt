package com.testingrx.model

import com.testingrx.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryApi {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Single<List<Country>>
}