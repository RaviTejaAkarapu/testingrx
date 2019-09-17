package com.testingrx.di

import com.testingrx.model.CountryService
import com.testingrx.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: CountryService)

    fun inject(viewModel: ListViewModel)
}