package com.example.aulacoroutines18112020

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeActivity : AppCompatActivity() {
    val repository = Repository()
    val viewModel by viewModels<HomeViewModel>{

        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnFor(items = viewModel.getFilmes(), Modifier.fillMaxSize()) {
                Text(it.name)
            }
        }
    }
}