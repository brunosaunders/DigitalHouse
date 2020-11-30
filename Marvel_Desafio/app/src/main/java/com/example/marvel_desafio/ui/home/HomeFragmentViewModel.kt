package com.example.marvel_desafio.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_desafio.repository.ComicsRepository
import kotlinx.coroutines.launch

class HomeFragmentViewModel : ViewModel() {
    val repository = ComicsRepository

    val listComics = repository.comics

    fun refreshComics() {
        viewModelScope.launch {
            repository.refreshComics()
        }
    }
}