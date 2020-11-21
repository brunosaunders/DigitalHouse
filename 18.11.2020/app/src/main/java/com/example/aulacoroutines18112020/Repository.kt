package com.example.aulacoroutines18112020

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Repository {
    val filmes = MutableLiveData<List<Filme>>()
    val scope = CoroutineScope(Dispatchers.IO)

    fun refreshFilmes() {
        scope.launch {
            delay(2000)
            val filme01 = Filme(1, "Batman", 4.7)
            val filme02 = Filme(2, "Capitã Marvel", 3.2)
            val filme03 = Filme(3, "Esqueceram de Mim", 4.9)

            filmes.value = listOf(filme01, filme02, filme03)
        }

    }
}