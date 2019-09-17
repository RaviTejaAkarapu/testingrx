package com.testingrx

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel: ViewModel() {

    private val countryService = CountryService()
    private val disposable = CompositeDisposable()

    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading =  MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value = true
        disposable.add(
            countryService.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<Country>>(){
                    override fun onSuccess(data: List<Country>) {
                        countries.value = data
                        countryLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        countryLoadError.value = true
                        loading.value = false
                    }

                })
        )

//        val mockData = listOf(Country("countryA"),
//            Country("countryB"),
//            Country("countryC"),
//            Country("countryD"),
//            Country("countryE"),
//            Country("countryF"),
//            Country("countryG"),
//            Country("countryH"),
//            Country("countryI"),
//            Country("countryJ"),
//            Country("countryK")
//            )
//
//        countryLoadError.value = false
//        loading.value = false
//        countries.value = mockData
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}