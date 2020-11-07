package com.example.wallet.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.wallet.R
import kotlinx.android.synthetic.main.activity_profilee.*

class ProfileeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilee)

        setSupportActionBar(profile_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        val navController = findNavController(R.id.nav_host_fragment)
//        val configuration = AppBarConfiguration(navController.graph)
//
//        setupActionBarWithNavController(navController, configuration)
    }
}