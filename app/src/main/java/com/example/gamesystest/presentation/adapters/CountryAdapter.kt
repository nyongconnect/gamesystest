package com.example.gamesystest.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesystest.R
import com.example.gamesystest.databinding.LayoutCountryItemBinding
import com.example.gamesystest.presentation.extensions.displayImage
import com.example.gamesystest.presentation.model.Country

class CountryAdapter(private val context: Context, val onClick:(Country)-> Unit): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var countries = emptyList<Country>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(LayoutCountryItemBinding.bind(LayoutInflater.from(context).inflate(R.layout.layout_country_item, parent, false)))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(countries: List<Country>) {
        this.countries = countries
        notifyDataSetChanged()
    }

    inner class CountryViewHolder(val binding: LayoutCountryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(element: Country) {
            binding.countryName.text = element.name
            binding.imgFlag.displayImage(element.alpha2Code.lowercase().replace("-", "_"), context)
            itemView.setOnClickListener {
                onClick.invoke(element)
            }
        }
    }
}