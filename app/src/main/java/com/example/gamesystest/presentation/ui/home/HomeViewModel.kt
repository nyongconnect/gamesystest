package com.example.gamesystest.presentation.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesystest.domain.usecases.GetAllCountriesUseCase
import com.example.gamesystest.domain.usecases.AddCountriesToDbUseCase
import com.example.gamesystest.domain.usecases.GetCountriesFromDb
import com.example.gamesystest.presentation.mapper.toDomain
import com.example.gamesystest.presentation.model.Country
import com.example.gamesystest.presentation.mapper.toPresentation
import com.example.gamesystest.utils.AppConstant.API_KEY
import com.example.gamesystest.utils.Resources
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase,
    private val addCountriesToDbUseCase: AddCountriesToDbUseCase,
    private val getCountriesFromDb: GetCountriesFromDb
): ViewModel() {

    private val _countries = MutableLiveData<Resources<List<Country>>>()
    val countries: LiveData<Resources<List<Country>>> = _countries

    fun onFragmentReady() {
        loadCountries()
    }

    private fun loadCountries() {
        viewModelScope.launch {
            getAllCountriesUseCase.execute(API_KEY).onStart {
                getCountriesFromDb()
            }.catch {
                _countries.postValue(Resources.Failure("Something Happened"))
            }.collect { countries ->
                saveCountriesToDb(countries.map { it.toPresentation() })
                _countries.postValue(Resources.Success(countries.map { it.toPresentation()}))
            }
        }
    }

    private fun saveCountriesToDb(countries: List<Country>) {
        viewModelScope.launch {
            addCountriesToDbUseCase.execute(countries.map { it.toDomain() }).onStart {

            }.catch {

            }.collect {

            }
        }
    }

    private fun getCountriesFromDb() {
        viewModelScope.launch {
            getCountriesFromDb.execute().onStart {
                _countries.postValue(Resources.Loading(true))
            }.catch {

            }.collect {
                _countries.postValue(Resources.Success(it.map { it.toPresentation() }))
            }
        }
    }
}