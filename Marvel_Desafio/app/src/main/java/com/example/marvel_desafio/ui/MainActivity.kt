package com.example.marvel_desafio.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.marvel_desafio.R
import com.example.marvel_desafio.databinding.ActivityMainBinding
import com.example.marvel_desafio.util.SupportBar

class MainActivity : AppCompatActivity(), SupportBar {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)
        val navControler = findNavController(R.id.nav_host_fragment_main)
        setupActionBarWithNavController(navControler)
    }

    override val supportBar: androidx.appcompat.app.ActionBar?
        get() = supportActionBar

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_main)

        return navController.navigateUp()

    }
}