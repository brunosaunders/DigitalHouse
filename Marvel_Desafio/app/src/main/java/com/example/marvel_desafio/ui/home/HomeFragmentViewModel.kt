package com.example.marvel_desafio.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_desafio.repository.ComicsRepository
import kotlinx.coroutines.launch

class HomeFragmentViewModel : ViewModel() {
    val repository = ComicsRepository
    val page = MutableLiveData<Int>(0)

    val listComics = repository.comics

    fun refreshComics(characterId: Int, limit: Int) {
        viewModelScope.launch {
            repository.refreshComics(characterId, limit, page.value!!)

        }
    }
}