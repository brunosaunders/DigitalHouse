package com.example.marvel_desafio.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_desafio.domain.Comic
import com.example.marvel_desafio.network.MarvelApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ComicsRepository {
    private val _comics = MutableLiveData<List<Comic>>()
    val comics: LiveData<List<Comic>>
        get() = _comics

    suspend fun refreshComics() {

        withContext(Dispatchers.IO) {
            _comics.postValue(MarvelApi.retrofitService.getComics().data.results)

        }
    }
}