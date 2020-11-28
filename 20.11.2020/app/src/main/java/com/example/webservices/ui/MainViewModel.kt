package com.example.webservices.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webservices.models.Produto
import com.example.webservices.services.Repository
import kotlinx.coroutines.launch

class MainViewModel(val repositoryy: Repository) : ViewModel() {

    val listProdutos = MutableLiveData<List<Produto>>()


    fun getAllProdutos() {
        try {
            viewModelScope.launch {
                listProdutos.value = repositoryy.getAllProdutosRepo().produtos
            }
        } catch (e: Exception) {
            Log.e("MainViewModel", e.toString())
        }
    }
}