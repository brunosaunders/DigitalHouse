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

    val needToRefresh = MutableLiveData<Boolean>()
    val lastRefresh = MutableLiveData(System.currentTimeMillis())

    fun updateNeedToRefresh() {
        val thisRefresh = System.currentTimeMillis()

        if (needToRefresh.value == null) {
            lastRefresh.value = thisRefresh
            needToRefresh.value = true
            return
        }

        if (thisRefresh - lastRefresh.value!! < 1500L) {
            needToRefresh.value = false
        } else {
            needToRefresh.value = true
            lastRefresh.value = thisRefresh
        }
    }

    suspend fun refreshComics(characterId: Int, limit: Int, page: Int) {
        val offset = 1 + page * limit

        updateNeedToRefresh()

        if (needToRefresh.value!!) {

            withContext(Dispatchers.IO) {
                _comics.value?.let {
                    _comics.postValue(
                        it +
                                MarvelApi.retrofitService
                                    .getComics(
                                        characterId, limit, offset
                                    ).data.results
                    )
                }
                if (_comics.value == null) _comics.postValue(
                    MarvelApi.retrofitService
                        .getComics(
                            characterId, limit, offset
                        ).data.results
                )
            }
        }

    }
}