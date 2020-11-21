package com.example.aulacoroutines18112020

import androidx.lifecycle.ViewModel

class HomeViewModel(val repository: Repository) : ViewModel() {

    fun getFilmes(): List<Filme> {
        repository.refreshFilmes()

        return repository.filmes.value

    }
}