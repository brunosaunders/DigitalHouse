package com.example.sql

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataBaseHandler = DataBaseHandler(this)
        dataBaseHandler.addGastoDatabase(Gasto(1, "coca", 8.50))
        dataBaseHandler.addGastoDatabase(Gasto(11, "carro", 38500.50))
        val res = dataBaseHandler.getAllGastos()

        res.forEach{
            Log.i("MainActivity", it.toString())
        }
    }
}