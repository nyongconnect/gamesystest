package com.example.gamesystest.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesystest.R
import com.example.gamesystest.databinding.ItemDetailsLayoutBinding
import com.example.gamesystest.presentation.model.Country
import com.example.gamesystest.presentation.ui.details.CountryDetailsViewModel

class CountryDetailAdapter(private val context: Context): RecyclerView.Adapter<CountryDetailAdapter.CountryDetailsViewHolder>() {

    private var information = emptyList<CountryDetailsViewModel.Information.Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryDetailsViewHolder {
        return CountryDetailsViewHolder(ItemDetailsLayoutBinding.bind(LayoutInflater.from(context).inflate(R.layout.item_details_layout, parent, false)))
    }

    override fun onBindViewHolder(holder: CountryDetailsViewHolder, position: Int) {
        holder.bind(information[position])
    }

    override fun getItemCount(): Int = information.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(information: List<CountryDetailsViewModel.Information.Item>) {
        this.information = information
        notifyDataSetChanged()
    }

    inner class CountryDetailsViewHolder(val binding: ItemDetailsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(element: CountryDetailsViewModel.Information.Item) {
            binding.header.text = element.titleKey
            binding.textTitle.text = element.descriptionKey
        }
    }
}