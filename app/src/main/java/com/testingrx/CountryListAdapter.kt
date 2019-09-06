package com.testingrx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_country.view.*

class CountryListAdapter(var countries: ArrayList<Country>) :
    RecyclerView.Adapter<CountryListViewHolder>() {

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
    )


    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: CountryListViewHolder, position: Int) {
        holder.bind(countries[position])
    }
}

class CountryListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val countryName = view.name

    fun bind(country: Country) {
        countryName.text = country.countryName
    }
}
