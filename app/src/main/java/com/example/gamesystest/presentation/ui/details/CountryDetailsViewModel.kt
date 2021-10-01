package com.example.gamesystest.presentation.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gamesystest.presentation.extensions.listToString
import com.example.gamesystest.presentation.model.Country

class CountryDetailsViewModel @ViewModelInject constructor(): ViewModel() {

    val lifeData: MutableLiveData<ViewState> = MutableLiveData()

    fun loadInformation(element: Country) {

        val list = mutableListOf(
            Information.Item(
                titleKey = "Capital",
                descriptionKey = element.capital
            ),
            Information.Item(
                titleKey = "Alpha2Code",
                descriptionKey = element.alpha2Code
            ),
            Information.Item(
                titleKey = "Region",
                descriptionKey = element.region
            ),
            Information.Item(
                titleKey = "Calling Codes",
                descriptionKey = listToString(element.callingCodes)
            ),
            Information.Item(
                titleKey = "Alt Spellings",
                descriptionKey = listToString(element.altSpellings)
            ),
        )
        lifeData.postValue(ViewState(list))
    }

    data class ViewState(val list: List<Information.Item>)

    sealed class Information {
        data class Item(val titleKey: String, val descriptionKey: String) : Information()
    }
}