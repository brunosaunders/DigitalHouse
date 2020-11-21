package com.example.webservices.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webservices.models.Aluno
import com.example.webservices.services.Repository
import kotlinx.coroutines.launch

class MainViewModel(val repositoryy: Repository) : ViewModel() {
    val aluno = MutableLiveData<Aluno>()
    val listAlunos = MutableLiveData<List<Aluno>>()

    fun getSortAluno() {
        try {
            viewModelScope.launch {
                aluno.value = repositoryy.getSortAluno()
            }
        } catch (e: Exception) {
            Log.e("MainViewModel", e.toString())
        }
    }

    fun getAllAlunos() {
        try {
            viewModelScope.launch {
                listAlunos.value = repositoryy.getAllAlunosRepo()
            }
        } catch (e: Exception) {
            Log.e("MainViewModel", e.toString())
        }
    }
}