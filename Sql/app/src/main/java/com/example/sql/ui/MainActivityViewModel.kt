package com.example.sql.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sql.Gasto
import com.example.sql.service.Repository
import kotlinx.coroutines.launch

class MainActivityViewModel(val repository: Repository) : ViewModel() {


    val listGastos = MutableLiveData<List<Gasto>>()

    fun addGastoIntoDatabase(gasto: Gasto) {

        viewModelScope.launch {
            listGastos.postValue(repository.addGastoTask(gasto))
        }
    }

    fun getAllGastoFromDatabase() {
        viewModelScope.launch {
            listGastos.postValue(repository.getAllGastosTask())
        }
    }
}