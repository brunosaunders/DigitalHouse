package com.example.sql.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sql.Gasto
import com.example.sql.R
import com.example.sql.database.AppDataBase
import com.example.sql.service.Repository
import com.example.sql.service.RepositoryImplement

class MainActivity : AppCompatActivity() {
    private lateinit var appDatabase: AppDataBase
    private lateinit var repository: Repository
    val viewModel: MainActivityViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainActivityViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDB()
        repository = RepositoryImplement(appDatabase.gastoDao())

        viewModel.addGastoIntoDatabase(Gasto(0, "Transporte", 1.75))

        viewModel.listGastos.observe(this) {
            Log.i("MainActivity", it.toString())
        }
    }

    fun initDB() {
        appDatabase = AppDataBase.invoke(this)
    }
}