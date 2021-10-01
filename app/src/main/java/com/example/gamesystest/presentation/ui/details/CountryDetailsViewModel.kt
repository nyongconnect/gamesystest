package com.example.gamesystest.presentation.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gamesystest.presentation.extensions.listToString
import com.example.gamesystest.presentation.model.Country

class CountryDetailsViewModel @ViewModelInject constructor(): ViewModel() {

    val countries: MutableLiveData<ViewState> = MutableLiveData()


    fun loadInformation(element: Country) {

        val list = mutableListOf(
            Information.Item(
                titleKey = "Capital",
                descriptionKey = element.capital
            ),
            Information.Item(
                titleKey = "Population",
                descriptionKey = element.population.toString()
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
                titleKey = "Sub region",
                descriptionKey = element.subregion
            ),
            Information.Item(
                titleKey = "Native name",
                descriptionKey = element.nativeName
            ),
            Information.Item(
                titleKey = "Timezone",
                descriptionKey = listToString(element.timezones)
            ),
            Information.Item(
                titleKey = "Calling Codes",
                descriptionKey = listToString(element.callingCodes)
            ),
            Information.Item(
                titleKey = "Alt Spellings",
                descriptionKey = listToString(element.altSpellings)
            )
        )
        countries.postValue(ViewState(list))
    }

    data class ViewState(val list: List<Information.Item>)

    sealed class Information {
        data class Item(val titleKey: String, val descriptionKey: String) : Information()
    }
}